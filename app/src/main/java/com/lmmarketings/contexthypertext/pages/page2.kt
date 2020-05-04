package com.lmmarketings.contexthypertext.pages

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lmmarketings.contexthypertext.*

import kotlinx.android.synthetic.main.fragment_page1.view.*
import kotlinx.android.synthetic.main.fragment_page2.view.*
import kotlinx.android.synthetic.main.fragment_page3.view.*

/**
 * A simple [Fragment] subclass.
 */
class page2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main= inflater.inflate(R.layout.fragment_page2, container, false)
        startTime=System.currentTimeMillis()
        main.page2_home.setOnClickListener {
            endTime =System.currentTimeMillis()
            timeTaken[2]= timeTaken[2]+((endTime!!- startTime!!).toDouble() /1000)
            noOfTransitions[1]= noOfTransitions[1]!!+1
            backButtonKeys.add(2)
            fragmentManager!!.beginTransaction().replace(R.id.container,page1()).addToBackStack("2").commit()
        }
        main.page2_next.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[2]= timeTaken[2]+((endTime!!- startTime!!).toDouble() /1000)
            noOfTransitions[3]= noOfTransitions[3]!!+1
            backButtonKeys.add(2)
            fragmentManager!!.beginTransaction().replace(R.id.container,page3()).addToBackStack("2").commit()
        }
        main.page2_tv3.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[2]= timeTaken[2]+((endTime!!- startTime!!).toDouble() /1000)
            noOfTransitions[6]= noOfTransitions[6]!!+1
            backButtonKeys.add(2)
            fragmentManager!!.beginTransaction().replace(R.id.container,page6()).addToBackStack("2").commit()
        }
        main.page2_tv4.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[2]= timeTaken[2]+((endTime!!- startTime!!).toDouble() /1000)
            noOfTransitions[6]= noOfTransitions[6]!!+1
            backButtonKeys.add(2)
            fragmentManager!!.beginTransaction().replace(R.id.container,page6()).addToBackStack("2").commit()
        }
        main.page2_tv5.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[2]= timeTaken[2]+((endTime!!- startTime!!).toDouble() /1000)
            noOfTransitions[7]= noOfTransitions[7]!!+1
            backButtonKeys.add(2)
            fragmentManager!!.beginTransaction().replace(R.id.container,page7()).addToBackStack("2").commit()

        }
        return main
    }

}
