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
import kotlinx.android.synthetic.main.fragment_page6.view.*

/**
 * A simple [Fragment] subclass.
 */
class page6 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main= inflater.inflate(R.layout.fragment_page6, container, false)
        startTime=System.currentTimeMillis()
        val page6_tv2=main.findViewById<TextView>(R.id.page6_tv2);
        val page6_tv7=main.findViewById<TextView>(R.id.page6_tv7);
        val tv6=getString(R.string.page6_2);
        val tv7=getString(R.string.page6_7);
        val ss1= SpannableString(tv6);
        val ss2= SpannableString(tv7);
        val clickableSpan1 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime =System.currentTimeMillis()
                timeTaken[6]= timeTaken[6]+((endTime!!- startTime!!).toDouble() /1000)
                backButtonKeys.add(6)
                noOfTransitions[2]= noOfTransitions[2]!!+1
                // We display a Toast. You could do anything you want here.
                fragmentManager!!.beginTransaction().replace(R.id.container,page2()).addToBackStack("6").commit()
            }
        }
        val clickableSpan2= object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                timeTaken[6]= timeTaken[6]+((endTime!!- startTime!!).toDouble() /1000)
                backButtonKeys.add(6)
                noOfTransitions[4]= noOfTransitions[4]!!+1
                // We display a Toast. You could do anything you want here.
                fragmentManager!!.beginTransaction().replace(R.id.container,page4()).addToBackStack("6").commit()
            }
        }
        ss1.setSpan(clickableSpan1,55,61,0)
        ss2.setSpan(clickableSpan2,25,34,0)
        page6_tv2.movementMethod= LinkMovementMethod.getInstance()
        page6_tv7.movementMethod= LinkMovementMethod.getInstance()
        page6_tv2.text=ss1
        page6_tv7.text=ss2
        main.page6_home.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[6]= timeTaken[6]+((endTime!!- startTime!!).toDouble() /1000)
            backButtonKeys.add(6)
            noOfTransitions[1]= noOfTransitions[1]!!+1
            fragmentManager!!.beginTransaction().replace(R.id.container,page1()).addToBackStack("6").commit()
        }
        main.page6_next.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[6]= timeTaken[6]+((endTime!!- startTime!!).toDouble() /1000)
            backButtonKeys.add(6)
            noOfTransitions[7]= noOfTransitions[7]!!+1
            fragmentManager!!.beginTransaction().replace(R.id.container,page7()).addToBackStack("6").commit()
        }
        return main
    }

}
