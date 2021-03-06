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
import kotlinx.android.synthetic.main.fragment_page5.view.*

/**
 * A simple [Fragment] subclass.
 */
class page5 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val main= inflater.inflate(R.layout.fragment_page5, container, false)
        isVisited[5]=1
        backButtonKeys.add(5)
//        noOfTransitions[5] = noOfTransitions[5]!! + 1
        startTime=System.currentTimeMillis()
        val page5_tv6=main.findViewById<TextView>(R.id.page5_tv6);
        val page5_tv7=main.findViewById<TextView>(R.id.page5_tv7);
        val tv6=getString(R.string.page5_6);
        val tv7=getString(R.string.page5_7);
        val ss1= SpannableString(tv6);
        val ss2= SpannableString(tv7);
        val clickableSpan1 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime =System.currentTimeMillis()
                noOfTransitions[2]= noOfTransitions[2]!!+1
                timeTaken[5]= timeTaken[5]+((endTime!!- startTime!!).toDouble() /1000)
                fragmentManager!!.beginTransaction().replace(R.id.container,page2()).addToBackStack("5").commit()
            }
        }
        val clickableSpan2= object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                noOfTransitions[8]= noOfTransitions[8]!!+1
                timeTaken[5]= timeTaken[5]+((endTime!!- startTime!!).toDouble() /1000)
                fragmentManager!!.beginTransaction().replace(R.id.container,page8()).addToBackStack("5").commit()
            }
        }
        ss1.setSpan(clickableSpan1,15,43,0)
        ss2.setSpan(clickableSpan2,13,25,0)
        page5_tv6.movementMethod= LinkMovementMethod.getInstance()
        page5_tv7.movementMethod= LinkMovementMethod.getInstance()
        page5_tv6.text=ss1
        page5_tv7.text=ss2
        return main
    }

}
