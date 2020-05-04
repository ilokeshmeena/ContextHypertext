package com.lmmarketings.contexthypertext.pages

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.lmmarketings.contexthypertext.*

import kotlinx.android.synthetic.main.fragment_page1.view.*
import kotlinx.android.synthetic.main.fragment_page4.view.*

/**
 * A simple [Fragment] subclass.
 */
class page4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main=inflater.inflate(R.layout.fragment_page4, container, false)
        startTime=System.currentTimeMillis()
        val page4_tv3=main.findViewById<TextView>(R.id.page4_tv3);
        val page4_tv5=main.findViewById<TextView>(R.id.page4_tv5);
        val tv3=getString(R.string.page4_3);
        val tv5=getString(R.string.page4_5);
        val ss1= SpannableString(tv3);
        val ss2= SpannableString(tv5);
        val clickableSpan1 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // We display a Toast. You could do anything you want here.
                endTime =System.currentTimeMillis()
                timeTaken[4]= timeTaken[4]+((endTime!!- startTime!!).toDouble() /1000)
                backButtonKeys.add(4)
                noOfTransitions[6]= noOfTransitions[6]!!+1
                fragmentManager!!.beginTransaction().replace(R.id.container,page6()).addToBackStack("4").commit()
            }
        }
        val clickableSpan2= object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                timeTaken[4]= timeTaken[4]+((endTime!!- startTime!!).toDouble() /1000)
                // We display a Toast. You could do anything you want here.
                backButtonKeys.add(4)
                noOfTransitions[4]= noOfTransitions[4]!!+1
                fragmentManager!!.beginTransaction().replace(R.id.container,page8()).addToBackStack("4").commit()
            }
        }
        ss1.setSpan(clickableSpan1,57,70,0)
        ss2.setSpan(clickableSpan2,56,67,0)
        page4_tv3.movementMethod= LinkMovementMethod.getInstance()
        page4_tv5.movementMethod= LinkMovementMethod.getInstance()
        page4_tv3.text=ss1
        page4_tv5.text=ss2
        main.page4_home.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[4]= timeTaken[4]+((endTime!!- startTime!!).toDouble() /1000)
            backButtonKeys.add(4)
            noOfTransitions[1]= noOfTransitions[1]!!+1
            fragmentManager!!.beginTransaction().replace(R.id.container,page1()).addToBackStack("4").commit()
        }
        main.page4_next.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[4]= timeTaken[4]+((endTime!!- startTime!!).toDouble() /1000)
            backButtonKeys.add(4)
            noOfTransitions[5]= noOfTransitions[5]!!+1
            fragmentManager!!.beginTransaction().replace(R.id.container,page5()).addToBackStack("4").commit()
        }
        return main;
    }

}
