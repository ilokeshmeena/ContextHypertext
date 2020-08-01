package com.lmmarketings.contexthypertext

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.lmmarketings.contexthypertext.data.json.RetrofitClient
import com.lmmarketings.contexthypertext.data.viewmodel.ResultX
import com.lmmarketings.contexthypertext.pages.ResultAdapter
import kotlinx.android.synthetic.main.fragment_result.view.*
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * A simple [Fragment] subclass.
 */
class Result : Fragment(),CoroutineScope {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main= inflater.inflate(R.layout.fragment_result, container, false)
//        try {
//            MainActivity().cameraSource.stop()
//        }catch (e:Exception){
//            Toast.makeText(requireContext(),e.message,Toast.LENGTH_SHORT).show()
//        }
        isLastPage=true
        backButtonKeys.add(9)
//        backButtonKeys.clear()
//        noOfTransitions.fill(0, 0)
//        timeTaken.fill(0.0, 0)
        averageTime=0.0;
        averageTransition=0;
//        for(x in 0..9){
//            if(x%2!=0){
//                noOfTransitions[x]= (noOfTransitions[x]/2)+1
//            }
//        }
        for (x in noOfTransitions){
            averageTransition += x
        }
        for (x in timeTaken){
            averageTime +=x
        }
        main.tv_average_time.text="Average Transition : ${(averageTransition.toDouble()/8).toString()}"
        var averageTimeCal=averageTime.toDouble()/8
        if(averageTime.toString().length<=6){
            main.tv_average_transition.text="Average Time : ${(averageTime.toDouble()/8).toString()}"
        }else{
            main.tv_average_transition.text="Average Time : ${(averageTime.toDouble()/8).toString().substring(0,6)} s"
        }
        timeEye= eyeTimeTaken/ noOfTimesEye.toDouble()
        if(timeEye!! >0.0) {
            if(timeEye.toString().length<=6){
                main.tv_time_taken_eyes.text="Eye Fixation : ${timeEye.toString()} ms"
            }else{
                timeEye= timeEye.toString().substring(0,6).toDouble()
                main.tv_time_taken_eyes.text="Eye Fixation : ${timeEye.toString().substring(0,6)} ms"
            }
        }else{
            timeEye=0.0
            main.tv_time_taken_eyes.text="Eye Fixation : 0 ms"
        }
//        main.tv_time_taken_eyes.text="Eye Average Time : ${noOfTimesEye.toString()} & ${noOfTimesEyeClosed.toString()} & ${noOfTimesEyeNotFound.toString()}"
        main.rvMain.layoutManager=GridLayoutManager(requireContext(),3,GridLayoutManager.HORIZONTAL,false)
        main.rvMain.adapter=ResultAdapter(noOfTransitions, timeTaken)
        main.result_new.setOnClickListener {
            reassignEverything()
            startActivity(Intent(requireContext(),StartMain::class.java))
        }
        val progressDialog=ProgressDialog(requireContext());
        progressDialog.setMessage("Saving.......")
        progressDialog.setCancelable(false)

        main.save_result.setOnClickListener {
            launch {
                progressDialog.show()
                try{
                    statusInternet=addNewData()
                    while (statusInternet==null){}
                    progressDialog.hide()
                    if(statusInternet==true){
                        Toast.makeText(requireContext(),"Saved Successfully",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(requireContext(),"Unsucessfull",Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){
                    AlertDialog.Builder(activity)
                        .setTitle("Error")
                        .setMessage(e.message)
                        .setPositiveButton("Ok",DialogInterface.OnClickListener { dialog, which -> })
                        .show()
                    progressDialog.hide()
                }
            }
        }
        return main
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    suspend fun  addNewData():Boolean{
        val api=RetrofitClient.postsApi
        val response=api.addNewData(body=ResultX(
            time1 = timeTaken[1].toString(),
            time2 = timeTaken[2].toString(),
            time3 = timeTaken[3].toString(),
            time4 = timeTaken[4].toString(),
            time5 = timeTaken[5].toString(),
            time6 = timeTaken[6].toString(),
            time7 = timeTaken[7].toString(),
            time8 = timeTaken[8].toString(),
            transition1 = noOfTransitions[1],
            transition2 = noOfTransitions[2],
            transition3 = noOfTransitions[3],
            transition4 = noOfTransitions[4],
            transition5 = noOfTransitions[5],
            transition6 = noOfTransitions[6],
            transition7 = noOfTransitions[7],
            transition8 = noOfTransitions[8],
            eyeFixation = timeEye.toString(),
            averageTransition = (averageTransition.toDouble()/8).toString(),
            averageTime = averageTime.toString(),
            modeType = "m"
        ))
        return if(response!=null){
          true
        }else{
            false
        }
    }

}
