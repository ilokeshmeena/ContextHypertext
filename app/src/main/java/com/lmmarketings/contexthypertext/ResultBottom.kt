package com.lmmarketings.contexthypertext

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_result_bottom.view.*

/**
 * A simple [Fragment] subclass.
 */
class ResultBottom : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main=inflater.inflate(R.layout.fragment_result_bottom, container, false)
        main.result_new.setOnClickListener {
            startActivity(Intent(requireContext(),StartMain::class.java))
        }
        main.save_result.setOnClickListener {
            Toast.makeText(requireContext(),"Saving", Toast.LENGTH_SHORT).show()
        }
        return  main
    }

}
