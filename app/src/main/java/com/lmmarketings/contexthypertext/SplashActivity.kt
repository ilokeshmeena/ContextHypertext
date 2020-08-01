package com.lmmarketings.contexthypertext

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Handler().postDelayed({ /* Create an Intent that will start the Menu-Activity. */
//            if(BuildConfig.BUILD_TYPE.contentEquals("online")){
//                falvour=0
//            }else if(BuildConfig.BUILD_TYPE.contentEquals("offline")){
//                falvour=1
//            }else{
//                falvour=2
//            }
//            if(falvour!=0){
                val mainIntent = Intent(this, MenuActivity::class.java)
                startActivity(mainIntent)
                this.finish()
//            }else{
//                val mainIntent = Intent(this, StartMain::class.java)
//                startActivity(mainIntent)
//                this.finish()
//            }
        }, 1000)
    }
}
