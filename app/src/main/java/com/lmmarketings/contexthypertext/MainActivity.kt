package com.lmmarketings.contexthypertext

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector.Detections
import com.google.android.gms.vision.MultiProcessor
import com.google.android.gms.vision.Tracker
import com.google.android.gms.vision.face.Face
import com.google.android.gms.vision.face.FaceDetector
import com.lmmarketings.contexthypertext.pages.*
import kotlinx.android.synthetic.main.main_activity.*
import java.io.IOException
import java.util.*


class MainActivity : AppCompatActivity() {

    //For looking logs
    var adapter: ArrayAdapter<*>? = null
    var list = ArrayList<String>()

    lateinit var cameraSource: CameraSource

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//        screenHeight = displayMetrics.heightPixels+bottom_navigation.height
//        val width = displayMetrics.widthPixels
//        container.layoutParams.height = screenHeight
        if (bottom_navigation.visibility == View.GONE) {
            bottom_navigation.visibility = View.VISIBLE
        }
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        createCameraSource()

        noOfTransitions(1)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, page1()).addToBackStack("0").commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_back -> {
                    onBackPressed()
                }
                R.id.action_home -> {
                    val i = backButtonKeys.last()
                    if (i != 1) {
                        transitionTime()
                        noOfTransitions(1)
                        supportFragmentManager!!.beginTransaction().replace(R.id.container, page1())
                            .addToBackStack(i.toString()).commit()
                    } else {
                        Toast.makeText(this, "Your'e on home page", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.action_end -> {
                    if (isVisitedToAll()) {
                        transitionTime()
                        bottom_navigation.visibility = View.GONE
                        supportFragmentManager!!.beginTransaction()
                            .replace(R.id.container, Result())
                            .addToBackStack(backButtonKeys.last().toString()).commit()
                    } else {
                        Toast.makeText(this, "You've not visited all pages yet", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                R.id.action_next -> {
                    onForwardButtonPressed()
                }
            }
            true
        }

    }

    @ExperimentalStdlibApi
    override fun onBackPressed() {
        if (isLastPage) {
            Toast.makeText(this, "Click on buttons below", Toast.LENGTH_SHORT).show()
        } else if (backButtonKeys.isNotEmpty() && backButtonKeys.last() > 1) {
            super.onBackPressed()
            onBackButtonPressed()
        } else {
            Toast.makeText(this, "Your'e on the first page", Toast.LENGTH_SHORT).show()
        }

    }

    @ExperimentalStdlibApi
    fun onForwardButtonPressed() {
        if (backButtonKeys.isNotEmpty()) {
            when (backButtonKeys.last()) {
                1 -> {
                    transitionTime()
                    noOfTransitions(2)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page2())
                        .addToBackStack("1").commit()
                }
                2 -> {
                    transitionTime()
                    noOfTransitions(3)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page3())
                        .addToBackStack("2").commit()
                }
                3 -> {
                    transitionTime()
                    noOfTransitions(4)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page4())
                        .addToBackStack("3").commit()
                }
                4 -> {
                    transitionTime()
                    noOfTransitions(5)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page5())
                        .addToBackStack("4").commit()
                }
                5 -> {
                    transitionTime()
                    noOfTransitions(6)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page6())
                        .addToBackStack("5").commit()
                }
                6 -> {
                    transitionTime()
                    noOfTransitions(7)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page7())
                        .addToBackStack("6").commit()
                }
                7 -> {
                    transitionTime()
                    noOfTransitions(8)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page8())
                        .addToBackStack("7").commit()
                }
                8 -> {
                    if (isVisitedToAll()) {
                        bottom_navigation.visibility = View.GONE
                        transitionTime()
                        supportFragmentManager!!.beginTransaction()
                            .replace(R.id.container, Result())
                            .addToBackStack("8").commit()
                    } else {
                        Toast.makeText(this, "You've not visited all pages yet", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.container, page1())
                .commit()
        }
    }

    @ExperimentalStdlibApi
    fun onBackButtonPressed() {
        val lastElement = backButtonKeys.last()
        backButtonKeys.removeLast()
        when (lastElement) {
            1 -> {
                transitionTime()
                noOfTransitions(1)
                supportFragmentManager.beginTransaction().replace(R.id.container, page1())
                    .commit()
            }
            2 -> {
                transitionTime()
                noOfTransitions(2)
                supportFragmentManager.beginTransaction().replace(R.id.container, page2())
                    .commit()
            }
            3 -> {
                transitionTime()
                noOfTransitions(3)
                supportFragmentManager.beginTransaction().replace(R.id.container, page3())
                    .commit()
            }
            4 -> {
                transitionTime()
                noOfTransitions(4)
                supportFragmentManager.beginTransaction().replace(R.id.container, page4())
                    .commit()
            }
            5 -> {
                transitionTime()
                noOfTransitions(5)
                supportFragmentManager.beginTransaction().replace(R.id.container, page5())
                    .commit()
            }
            6 -> {
                transitionTime()
                noOfTransitions(6)
                supportFragmentManager.beginTransaction().replace(R.id.container, page6())
                    .commit()
            }
            7 -> {
                transitionTime()
                noOfTransitions(7)
                supportFragmentManager.beginTransaction().replace(R.id.container, page7())
                    .commit()
            }
            8 -> {
                transitionTime()
                noOfTransitions(8)
                supportFragmentManager.beginTransaction().replace(R.id.container, page8())
                    .commit()
            }
        }
    }

    private fun isVisitedToAll(): Boolean {
        for (i in 1..8) {
            if (isVisited[i] == 0) {
                return false
            }
        }
        return true
    }

    //This class will use google vision api to detect eyes
    private inner class EyesTracker : Tracker<Face>() {
        private val threshold = 0.75f
        override fun onUpdate(detections: Detections<Face>, face: Face) {
            if (face.isLeftEyeOpenProbability > threshold && face.isRightEyeOpenProbability > threshold) {
                if (isOldEye.last() != 1) {
                    isOldEye.add(1)
                    startTimeEye = System.currentTimeMillis()
                    noOfTimesEye += 1

                }
            } else {
                if (isOldEye.last() == 1) {
                    endTimeEye = System.currentTimeMillis()
                    isOldEye.add(0)
//                    noOfTimesEyeClosed += 1
                    eyeTimeTaken += (endTimeEye!! - startTimeEye!!)
                }
            }
        }

        override fun onMissing(detections: Detections<Face>) {
            super.onMissing(detections)
            if (isOldEye.last() == 1) {
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
            .build().start()
    }

    fun currentPage(): Int {
        return if (backButtonKeys.isEmpty()) {
            0
        } else {
            backButtonKeys.last()
        }
    }

    fun transitionTime() {
        endTime = System.currentTimeMillis()
//        transitionTimeEyes( endTime!!)
        timeTaken[currentPage()] =
            timeTaken[currentPage()] + ((endTime!! - startTime!!).toDouble() / 1000)
    }

    fun noOfTransitions(page: Int) {
        noOfTransitions[page] = noOfTransitions[page]!! + 1
    }

}