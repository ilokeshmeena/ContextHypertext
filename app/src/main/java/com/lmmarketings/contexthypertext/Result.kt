package com.lmmarketings.contexthypertext

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.lmmarketings.contexthypertext.pages.ResultAdapter
import kotlinx.android.synthetic.main.fragment_result.view.*
import kotlinx.android.synthetic.main.main_activity.*

/**
 * A simple [Fragment] subclass.
 */
class Result : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main= inflater.inflate(R.layout.fragment_result, container, false)
        isLastPage=true
//        backButtonKeys.clear()
//        noOfTransitions.fill(0, 0)
//        timeTaken.fill(0.0, 0)
        var averageTime=0.0;
        var averageTransition=0;
        for (x in noOfTransitions){
            averageTransition += x
        }
        for (x in timeTaken){
            averageTime +=x
        }
        main.tv_average_time.text="Average Transition : ${(averageTransition.toDouble()/8).toString()}"
        main.tv_average_transition.text="Average Time : ${(averageTime.toDouble()/8).toString()}"
        main.rvMain.layoutManager=GridLayoutManager(requireContext(),4,GridLayoutManager.HORIZONTAL,false)
        main.rvMain.adapter=ResultAdapter(noOfTransitions, timeTaken)
        main.result_new.setOnClickListener {
            startActivity(Intent(requireContext(),StartMain::class.java))
        }
        main.save_result.setOnClickListener {
            Toast.makeText(requireContext(),"Saving",Toast.LENGTH_SHORT).show()
        }
        return main
    }

}
