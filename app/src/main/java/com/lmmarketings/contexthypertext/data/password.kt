package com.lmmarketings.contexthypertext.data

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chaos.view.PinView

import com.lmmarketings.contexthypertext.R
import kotlinx.android.synthetic.main.fragment_password.view.*

/**
 * A simple [Fragment] subclass.
 */
class password : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main=inflater.inflate(R.layout.fragment_password, container, false)
        main.login_offline.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.container2,showDataOffline()).commit()
        }
        main.login_online.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.container2,showData()).commit()
        }
        return main
    }

}
