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
import kotlinx.android.synthetic.main.fragment_page8.view.*

/**
 * A simple [Fragment] subclass.
 */
class page8 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main= inflater.inflate(R.layout.fragment_page8, container, false)
        isVisited[8]=1
        backButtonKeys.add(8)
        noOfTransitions[8] = noOfTransitions[8]!! + 1
        startTime=System.currentTimeMillis()
        val page8_tv2=main.findViewById<TextView>(R.id.page8_tv2);
        val page8_tv4=main.findViewById<TextView>(R.id.page8_tv4);
        val tv2=getString(R.string.page8_2);
        val tv4=getString(R.string.page8_4);
        val ss1= SpannableString(tv2);
        val ss2= SpannableString(tv4);
        val clickableSpan1 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                timeTaken[8]= timeTaken[8]+((endTime!!- startTime!!).toDouble() /1000)
                fragmentManager!!.beginTransaction().replace(R.id.container,page3()).addToBackStack("8").commit()
            }
        }
        val clickableSpan2= object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                timeTaken[8]= timeTaken[8]+((endTime!!- startTime!!).toDouble() /1000)
                fragmentManager!!.beginTransaction().replace(R.id.container,page2()).addToBackStack("8").commit()
            }
        }
        ss1.setSpan(clickableSpan1,80,91,0)
        ss2.setSpan(clickableSpan2,160,166,0)
        page8_tv2.movementMethod= LinkMovementMethod.getInstance()
        page8_tv4.movementMethod= LinkMovementMethod.getInstance()
        page8_tv2.text=ss1
        page8_tv4.text=ss2
        return main
    }

}
