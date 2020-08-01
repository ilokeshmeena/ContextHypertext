package com.lmmarketings.contexthypertext

import android.Manifest
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.MultiProcessor
import com.google.android.gms.vision.Tracker
import com.google.android.gms.vision.face.Face
import com.google.android.gms.vision.face.FaceDetector
import com.lmmarketings.contexthypertext.data.json.RetrofitClient
import com.lmmarketings.contexthypertext.data.viewmodel.ResultX
import kotlinx.android.synthetic.main.activity_offline.*
import kotlinx.android.synthetic.main.fragment_result.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.ArrayList
import kotlin.coroutines.CoroutineContext

class offline : AppCompatActivity(),CoroutineScope {
    var adapter: ArrayAdapter<*>? = null
    var list = ArrayList<String>()
    lateinit var cameraSource:CameraSource
    var isStop:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline)
        var isStart=0
        val progressDialog2=ProgressDialog(this);
        progressDialog2.setCancelable(false)
        progressDialog2.setMessage("Starting camera.....")
        offline_start_button.setOnClickListener {
            if(isStart==1){
                isStop=true
                endTimeoffline=System.currentTimeMillis()
                cameraSource.stop()
                offline_home.visibility= View.VISIBLE
                offline_start_button.text="Save"
                offlineTime=((endTimeoffline!! - startTimeoffline!!).toDouble()/1000)
                offline_timer.text= offlineTime.toString() +" s"
                timeEye= eyeTimeTaken/ noOfTimesEye.toDouble()
                if(timeEye!! >0.0) {
                    if(timeEye.toString().length<=6){
                        offline_timer_eye.text="${timeEye.toString()} ms"
                    }else{
                        timeEye= timeEye.toString().substring(0,6).toDouble()
                        offline_timer_eye.text="${timeEye.toString().substring(0,6)} ms"
                    }
                }else{
                    timeEye=0.0
                    offline_timer_eye.text="Eye Fixation : 0 ms"
                }
                isStart=2
            }else if(isStart==0){
                progressDialog2.show()
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
                isOldEye.add(2)
                createCameraSource()
                startTimeoffline=System.currentTimeMillis()
                isStart=1
                offline_start_button.text="Stop"
                first()
                progressDialog2.hide()
            }else {
                //save result
                val progressDialog= ProgressDialog(this);
                progressDialog.setMessage("Saving.......")
                progressDialog.setCancelable(false)
                launch {
                    progressDialog.show()
                    try{
                        statusInternet=addNewData()
                        while (statusInternet==null){}
                        progressDialog.hide()
                        if(statusInternet==true){
                            Toast.makeText(this@offline,"Saved Successfully", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@offline,"Unsucessfull", Toast.LENGTH_SHORT).show()
                        }
                    }catch (e:Exception){
                        AlertDialog.Builder(this@offline)
                            .setTitle("Error")
                            .setMessage(e.message)
                            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> })
                            .show()
                        progressDialog.hide()
                    }
                }
            }
        }

        offline_home.setOnClickListener {
            reassignEverything()
            startActivity(Intent(this,MenuActivity::class.java))
        }
    }
    private fun first(){
        Handler().postDelayed({ /* Create an Intent that will start the Menu-Activity. */
            if(!isStop){
                offline_timer.text= ((System.currentTimeMillis()- startTimeoffline!!).toDouble()/1000).toString() + " s"
                var timeEye=(eyeTimeTaken/ noOfTimesEye.toDouble())
                if(timeEye.toString().length<=5){
                    offline_timer_eye.text="${timeEye} ms"
                }else{
                    offline_timer_eye.text="${timeEye.toString().substring(0,5)} ms"
                }
                second()
            }
        }, 100)
    }
    private fun second(){
        Handler().postDelayed({ /* Create an Intent that will start the Menu-Activity. */
            if(!isStop){
                offline_timer.text= ((System.currentTimeMillis()- startTimeoffline!!).toDouble()/1000).toString() + " s"
                var timeEye=(eyeTimeTaken/ noOfTimesEye.toDouble())
                if(timeEye.toString().length<=5){
                    offline_timer_eye.text="${timeEye} ms"
                }else{
                    offline_timer_eye.text="${timeEye.toString().substring(0,5)} ms"
                }
               first()
            }
        }, 100)
    }
    private inner class EyesTracker : Tracker<Face>() {
        private val threshold = 0.75f
        override fun onUpdate(detections: Detector.Detections<Face>, face: Face) {
            if (face.isLeftEyeOpenProbability > threshold && face.isRightEyeOpenProbability > threshold) {
                if (isOldEye.last() !=  1) {
                    isOldEye.add(1)
                    startTimeEye = System.currentTimeMillis()
                    noOfTimesEye += 1

                }
            } else {
                if(isOldEye.last()==1){
                    endTimeEye = System.currentTimeMillis()
                    isOldEye.add(0)
//                    noOfTimesEyeClosed += 1
                    eyeTimeTaken += (endTimeEye!! - startTimeEye!!)
                }
            }
        }
        override fun onMissing(detections: Detector.Detections<Face>) {
            super.onMissing(detections)
            if(isOldEye.last()==1) {
                endTimeEye = System.currentTimeMillis()
                isOldEye.add(0)
//                noOfTimesEyeNotFound += 1
                eyeTimeTaken += (endTimeEye!! - startTimeEye!!)
            }

        }

        override fun onDone() {
            super.onDone()
        }
    }

    private inner class FaceTrackerFactory : MultiProcessor.Factory<Face> {
        override fun create(face: Face): Tracker<Face> {
            return EyesTracker()
        }
    }

    fun createCameraSource() {
        val detector = FaceDetector.Builder(this)
            .setTrackingEnabled(true)
            .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
            .setMode(FaceDetector.FAST_MODE)
            .build()
        detector.setProcessor(MultiProcessor.Builder<Face>(FaceTrackerFactory()).build())
        cameraSource = CameraSource.Builder(this, detector)
            .setRequestedPreviewSize(1024, 768)
            .setFacing(CameraSource.CAMERA_FACING_FRONT)
            .setRequestedFps(30.0f)
            .build()
        try {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            cameraSource.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


//    override fun onResume() {
//        super.onResume()
//        try {
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.CAMERA
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                return
//            }
//            cameraSource.start()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }

//    override fun onDestroy() {
//        super.onDestroy()
//        cameraSource.release()
//    }

    suspend fun  addNewData():Boolean{
        val api= RetrofitClient.postsApi
        val response=api.addNewData(body= ResultX(
            time1 = "0",
            time2 = "0",
            time3 = "0",
            time4 = "0",
            time5 = "0",
            time6 = "0",
            time7 = "0",
            time8 = "0",
            transition1 = 0,
            transition2 = 0,
            transition3 = 0,
            transition4 = 0,
            transition5 = 0,
            transition6 = 0,
            transition7 = 0,
            transition8 = 0,
            eyeFixation = timeEye.toString(),
            averageTransition ="0",
            averageTime = offlineTime.toString(),
            modeType = "o"
        )
        )
        return if(response!=null){
            true
        }else{
            false
        }
    }
}
