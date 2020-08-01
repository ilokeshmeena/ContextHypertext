package com.lmmarketings.contexthypertext

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.DisplayMetrics
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_start_main.*
import kotlinx.android.synthetic.main.main_activity.*

class StartMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_main)
//        isLastPage=false
//        backButtonKeys.clear()
//        noOfTransitions.fill(0, 0)
//        timeTaken.fill(0.0, 0)
//        eyeTimeTaken=0
//        noOfTimesEye=0
//        noOfTimesEyeNotFound=0
//        noOfTimesEyeClosed=0
//        timeEye=0.0
//        statusInternet=null
//        isOldEye.clear()
//        isOldEye.add(2)
//        startTimeEye=0
//        endTimeEye=0
//        isVisited.fill(0,0)
        reassignEverything()
        startButton.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
                Toast.makeText(this, "Click again on start button", Toast.LENGTH_LONG).show()
            } else {
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }
}
