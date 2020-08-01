package com.lmmarketings.contexthypertext.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lmmarketings.contexthypertext.R
import com.lmmarketings.contexthypertext.data.viewmodel.ResultX
import kotlinx.android.synthetic.main.showdataofflineresult.view.*

class ResultAdapterInternetOffline(val result:List<ResultX>) :
    RecyclerView.Adapter<ResultAdapterInternetOffline.ResultViewHolder>() {

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ResultViewHolder {
        val li = p0.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.showdataofflineresult, p0, false)
        return ResultViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(p0: ResultViewHolder, p1: Int) {

        p0.itemView.offline_page_no.text="Result : ${p1+1}"
        p0.itemView.offline_page_time.text="Time Taken : "+result[p1].averageTime+" s"
        p0.itemView.offline_page_eye.text="Eye Fixation : "+result[p1].eyeFixation+" ms"
//        val transition = result[p1 + 1]
//        val timeTaken = time[p1 + 1]
//        val timeTakenEyes=eyeTime[p1+1]
//        p0.itemView.tv_pageNo.text = "Page No: ${p1 + 1}"
//        p0.itemView.tv_no_of_transitions.text = "No of Transition : ${transition.toString()}"
//        if (timeTaken.toString().length <= 6) {
//            p0.itemView.tv_time_taken.text = "Time Taken : ${timeTaken.toString()}s"
//        } else {
//            p0.itemView.tv_time_taken.text = "Time Taken : ${timeTaken.toString().substring(0, 6)}s"
//        }
//        if (timeTakenEyes.toString().length <= 6) {
//            p0.itemView.tv_time_taken_eyes.text = "Time Taken Eyes : ${timeTakenEyes.toString()}s"
//        } else {
//            p0.itemView.tv_time_taken_eyes.text = "Time Taken Eyes : ${timeTakenEyes.toString().substring(0, 6)}s"
//        }
    }

}