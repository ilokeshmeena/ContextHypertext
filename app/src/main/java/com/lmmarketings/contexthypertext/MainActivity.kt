package com.lmmarketings.contexthypertext

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.lmmarketings.contexthypertext.pages.*
import kotlinx.android.synthetic.main.main_activity.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        backButtonKeys.clear()
        noOfTransitions.fill(0,0)
        timeTaken.fill(0.0,0)
        startButton.setOnClickListener {
            startButton.visibility= View.GONE
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)
//            supportActionBar?.setDisplayShowHomeEnabled(true)
            backButtonKeys.add(0)
            noOfTransitions[1]= noOfTransitions[1]!!+1
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, page1()).addToBackStack("0").commit()
        }
    }

    @ExperimentalStdlibApi
    override fun onBackPressed() {
        super.onBackPressed()
        if (!backButtonKeys.isEmpty()) {
            val lastElement = backButtonKeys.last()
            backButtonKeys.removeLast()
            when (lastElement) {
                0->{
//                    supportFragmentManager.beginTransaction().replace(R.id.container,page1()).commit()
                    Toast.makeText(this,"Press Back Again To Exit",Toast.LENGTH_SHORT).show()
                }
                1 -> {
                    noOfTransitions[1]= noOfTransitions[1]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page1()).commit()
                }
                2 -> {
                    noOfTransitions[2]= noOfTransitions[2]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page2()).commit()
                }
                3->{
                    noOfTransitions[3]= noOfTransitions[3]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page3()).commit()
                }
                4->{
                    noOfTransitions[4]= noOfTransitions[4]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page4()).commit()
                }
                5->{
                    noOfTransitions[5]= noOfTransitions[5]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page5()).commit()
                }
                6->{
                    noOfTransitions[6]= noOfTransitions[6]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page6()).commit()
                }
                7->{
                    noOfTransitions[7]= noOfTransitions[7]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page7()).commit()
                }
                8->{
                    noOfTransitions[8]= noOfTransitions[8]!!+1
                    supportFragmentManager.beginTransaction().replace(R.id.container,page8()).commit()
                }
                9->{
                    startActivity(Intent(this,SplashActivity::class.java))
                }
            }
        } else{
            super.finishAffinity()
        }
//        startButton.visibility= View.VISIBLE
//        supportActionBar?.setDisplayHomeAsUpEnabled(false)
//        supportActionBar?.setDisplayShowHomeEnabled(false)
    }


}