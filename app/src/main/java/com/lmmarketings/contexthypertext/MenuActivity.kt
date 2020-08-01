package com.lmmarketings.contexthypertext

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
//        if(falvour==1){
//            menu_offline.visibility=View.VISIBLE
//        }
//        if(falvour==2){
//            menu_login.visibility=View.VISIBLE
//        }
//        menu_online.setOnClickListener {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
//                Toast.makeText(this, "Click again on start button", Toast.LENGTH_LONG).show()
//            } else {
//                startActivity(Intent(this,StartMain::class.java))
//            }
//        }
//        menu_offline.setOnClickListener {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
//                Toast.makeText(this, "Click again on start button", Toast.LENGTH_LONG).show()
//            } else {
//                startActivity(Intent(this,offline::class.java))
//            }
//        }

        menu_login.setOnClickListener {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
//                Toast.makeText(this, "Click again on start button", Toast.LENGTH_LONG).show()
//            } else {
                startActivity(Intent(this,GetData::class.java))
//            }
        }
    }
}
