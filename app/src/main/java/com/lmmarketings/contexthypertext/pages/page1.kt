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


/**
 * A simple [Fragment] subclass.
 */
class page1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main=inflater.inflate(R.layout.fragment_page1, container, false)

        startTime=System.currentTimeMillis()
        val page1_tv3=main.findViewById<TextView>(R.id.page1_tv3);
        val page1_tv5=main.findViewById<TextView>(R.id.page1_tv5);
        val tv3=getString(R.string.page1_3);
        val tv5=getString(R.string.page1_5);
        val ss1= SpannableString(tv3);
        val ss2= SpannableString(tv5);
        val clickableSpan1 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                timeTaken[1]= timeTaken[1]+((endTime!!- startTime!!).toDouble() /1000)
                backButtonKeys.add(1)
                noOfTransitions[5]= noOfTransitions[5]!!+1
                // We display a Toast. You could do anything you want here.
                fragmentManager!!.beginTransaction().replace(R.id.container,page5()).addToBackStack("1").commit()
            }
        }
        val clickableSpan2= object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                timeTaken[1]= timeTaken[1]+((endTime!!- startTime!!).toDouble() /1000)
                backButtonKeys.add(1)
                noOfTransitions[4]= noOfTransitions[4]!!+1
                // We display a Toast. You could do anything you want here.
                fragmentManager!!.beginTransaction().replace(R.id.container,page4()).addToBackStack("1").commit()
            }
        }
//        main.page1_home.setOnClickListener {
//            fragmentManager!!.beginTransaction().replace(R.id.container,page1()).addToBackStack("1").commit()
//        }
        main.page1_next.setOnClickListener {
            endTime=System.currentTimeMillis()
            timeTaken[1]= timeTaken[1]+((endTime!!- startTime!!).toDouble() /1000)
            backButtonKeys.add(1)
            noOfTransitions[2]= noOfTransitions[2]!!+1
            fragmentManager!!.beginTransaction().replace(R.id.container,page2()).addToBackStack("1").commit()
        }
        ss1.setSpan(clickableSpan1,16,28,0)
        ss2.setSpan(clickableSpan2,96,105,0)
        page1_tv3.movementMethod= LinkMovementMethod.getInstance()
        page1_tv5.movementMethod= LinkMovementMethod.getInstance()
        page1_tv3.text=ss1
        page1_tv5.text=ss2
        return main;
    }

}
