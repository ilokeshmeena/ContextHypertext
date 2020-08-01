package com.lmmarketings.contexthypertext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.chaos.view.PinView
import com.lmmarketings.contexthypertext.data.password
import com.lmmarketings.contexthypertext.data.showData
import kotlinx.android.synthetic.main.activity_get_data.*
import kotlinx.android.synthetic.main.fragment_password.view.*

class GetData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)
    supportFragmentManager!!.beginTransaction().replace(R.id.container2,password()).addToBackStack("getData").commit()
    }
}
