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
import kotlinx.android.synthetic.main.fragment_page7.view.*

/**
 * A simple [Fragment] subclass.
 */
class page7 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main= inflater.inflate(R.layout.fragment_page7, container, false)
        isVisited[7]=1
        backButtonKeys.add(7)
//        noOfTransitions[7] = noOfTransitions[7]!! + 1
        startTime=System.currentTimeMillis()
        val page7_tv2=main.findViewById<TextView>(R.id.page7_tv2);
        val page7_tv5=main.findViewById<TextView>(R.id.page7_tv5);
        val tv2=getString(R.string.page7_2);
        val tv5=getString(R.string.page7_5);
        val ss1= SpannableString(tv2);
        val ss2= SpannableString(tv5);
        val clickableSpan1 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime =System.currentTimeMillis()
                noOfTransitions[1]= noOfTransitions[1]!!+1
                timeTaken[7]= timeTaken[7]+((endTime!!- startTime!!).toDouble() /1000)
                fragmentManager!!.beginTransaction().replace(R.id.container,page1()).addToBackStack("7").commit()
            }
        }
        val clickableSpan2= object : ClickableSpan() {
            override fun onClick(widget: View) {
                endTime=System.currentTimeMillis()
                noOfTransitions[5]= noOfTransitions[5]!!+1
                timeTaken[7]= timeTaken[7]+((endTime!!- startTime!!).toDouble() /1000)
                fragmentManager!!.beginTransaction().replace(R.id.container,page5()).addToBackStack("7").commit()
            }
        }
        ss1.setSpan(clickableSpan1,30,38,0)
        ss2.setSpan(clickableSpan2,17,29,0)
        page7_tv2.movementMethod= LinkMovementMethod.getInstance()
        page7_tv5.movementMethod= LinkMovementMethod.getInstance()
        page7_tv2.text=ss1
        page7_tv5.text=ss2
        return main
    }

}
