package com.lmmarketings.contexthypertext

import com.lmmarketings.contexthypertext.data.viewmodel.Result

val backButtonKeys=ArrayList<Int>()
val noOfTransitions= arrayOf(0,0,0,0,0,0,0,0,0,0)
val timeTaken= DoubleArray(9)
var startTime:Long?=null
var endTime:Long?=null
var isLastPage=false
var isVisited=arrayOf(0,0,0,0,0,0,0,0,0,0)
var startTimeEye:Long?=null
var endTimeEye:Long?=null
var eyeTimeTaken:Long=0
var noOfTimesEye:Int=0
var noOfTimesEyeClosed:Int=0
var noOfTimesEyeNotFound:Int=0
var isOldEye=ArrayList<Int>()
var timeEye:Double?=null
var averageTransition=0;
var statusInternet:Boolean?=null;
var data:Result?=null
var dataLength:Int?=null
var current:Int?=null
var averageTime=0.0;
var startTimeoffline:Long?=null
var endTimeoffline:Long?=null
var offlineTime:Double?=null
var falvour:Int?=null
 fun reassignEverything(){
     statusInternet=null
     data=null
     dataLength=null
     current=null
     averageTime=0.0
     startTimeoffline=null
     endTimeoffline=null
     offlineTime=null
     noOfTimesEye=0
     isLastPage=false
     backButtonKeys.clear()
     startTime=0
     endTime=0
     startTimeEye=0
     endTimeEye=0
     noOfTransitions.fill(0, 0)
     timeTaken.fill(0.0, 0)
     eyeTimeTaken=0
     noOfTimesEye=0
     noOfTimesEyeNotFound=0
     noOfTimesEyeClosed=0
     timeEye=0.0
     statusInternet=null
     isOldEye.clear()
     isOldEye.add(2)
     startTimeEye=0
     endTimeEye=0
     isVisited.fill(0,0)
 }
//package com.lmmarketings.contexthypertext
//
//import android.Manifest
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.os.Bundle
//import android.support.v4.app.ActivityCompat
//import android.support.v7.app.AppCompatActivity
//import android.view.View
//import android.widget.Toast
//import com.google.android.gms.vision.CameraSource
//import com.google.android.gms.vision.Detector.Detections
//import com.google.android.gms.vision.MultiProcessor
//import com.google.android.gms.vision.Tracker
//import com.google.android.gms.vision.face.Face
//import com.google.android.gms.vision.face.FaceDetector
//import com.lmmarketings.contexthypertext.pages.*
//import kotlinx.android.synthetic.main.main_activity.*
//import java.io.IOException
//
//
//class MainActivity : AppCompatActivity() {
//    lateinit var cameraSource:CameraSource
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !== PackageManager.PERMISSION_GRANTED)
//        { ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
//            Toast.makeText(this, "Grant Permission and restart app", Toast.LENGTH_SHORT).show()
//        }else{
//
//        }
//        backButtonKeys.clear()
//        noOfTransitions.fill(0,0)
//        timeTaken.fill(0.0,0)
//        startButton.setOnClickListener {
//            startButton.visibility= View.GONE
////            supportActionBar?.setDisplayHomeAsUpEnabled(true)
////            supportActionBar?.setDisplayShowHomeEnabled(true)
//            backButtonKeys.add(0)
//            noOfTransitions[1]= noOfTransitions[1]!!+1
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, page1()).addToBackStack("0").commit()
//        }
//    }
//
//    @ExperimentalStdlibApi
//    override fun onBackPressed() {
//        super.onBackPressed()
//        if (!backButtonKeys.isEmpty()) {
//            val lastElement = backButtonKeys.last()
//            backButtonKeys.removeLast()
//            when (lastElement) {
//                0->{
////                    supportFragmentManager.beginTransaction().replace(R.id.container,page1()).commit()
//                    Toast.makeText(this,"Press Back Again To Exit",Toast.LENGTH_SHORT).show()
//                }
//                1 -> {
//                    noOfTransitions[1]= noOfTransitions[1]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page1()).commit()
//                }
//                2 -> {
//                    noOfTransitions[2]= noOfTransitions[2]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page2()).commit()
//                }
//                3->{
//                    noOfTransitions[3]= noOfTransitions[3]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page3()).commit()
//                }
//                4->{
//                    noOfTransitions[4]= noOfTransitions[4]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page4()).commit()
//                }
//                5->{
//                    noOfTransitions[5]= noOfTransitions[5]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page5()).commit()
//                }
//                6->{
//                    noOfTransitions[6]= noOfTransitions[6]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page6()).commit()
//                }
//                7->{
//                    noOfTransitions[7]= noOfTransitions[7]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page7()).commit()
//                }
//                8->{
//                    noOfTransitions[8]= noOfTransitions[8]!!+1
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page8()).commit()
//                }
//                9->{
//                    startActivity(Intent(this,SplashActivity::class.java))
//                }
//            }
//        } else{
//            super.finishAffinity()
//        }
////        startButton.visibility= View.VISIBLE
////        supportActionBar?.setDisplayHomeAsUpEnabled(false)
////        supportActionBar?.setDisplayShowHomeEnabled(false)
//    }
//
//
//}

