package com.lmmarketings.contexthypertext.pages

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lmmarketings.contexthypertext.*

import kotlinx.android.synthetic.main.fragment_page1.view.*
import kotlinx.android.synthetic.main.fragment_page3.view.*

/**
 * A simple [Fragment] subclass.
 */
class page3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val main= inflater.inflate(R.layout.fragment_page3, container, false)
        isVisited[3]=1
        backButtonKeys.add(3)
        noOfTransitions[3] = noOfTransitions[3]!! + 1
        startTime=System.currentTimeMillis()
        main.page3_tv4.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[3]= timeTaken[3]+((endTime!!- startTime!!).toDouble() /1000)
            fragmentManager!!.beginTransaction().replace(R.id.container,page8()).addToBackStack("3").commit()
        }
        main.page3_tv5.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[3]= timeTaken[3]+((endTime!!- startTime!!).toDouble() /1000)
            fragmentManager!!.beginTransaction().replace(R.id.container,page8()).addToBackStack("3").commit()
        }
        return  main
    }

}
