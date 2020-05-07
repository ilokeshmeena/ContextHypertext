package com.lmmarketings.contexthypertext

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start_main.*

class StartMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_main)
        isLastPage=false
        backButtonKeys.clear()
        noOfTransitions.fill(0, 0)
        timeTaken.fill(0.0, 0)
        isVisited.fill(0,0)
        startButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
