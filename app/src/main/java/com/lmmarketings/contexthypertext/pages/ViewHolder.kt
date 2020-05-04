package com.lmmarketings.contexthypertext.pages//package com.lmmarketings.contexthypertext.pages
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lmmarketings.contexthypertext.R
import kotlinx.android.synthetic.main.list_result.view.*

class ResultAdapter(val result:Array<Int>,val time:DoubleArray) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>(){

    class ResultViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ResultViewHolder {
        val li = p0.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_result,p0,false)
        return ResultViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return time.size-1
    }

    override fun onBindViewHolder(p0: ResultViewHolder, p1: Int) {
        val transition=result[p1+1]
        val timeTaken=time[p1+1]
            p0.itemView.tv_pageNo.text="Page No: ${p1+1}"
            p0.itemView.tv_no_of_transitions.text="No of Transition : ${transition.toString()}"
            if(timeTaken.toString().length<=6){
                p0.itemView.tv_time_taken.text="Time Taken : ${timeTaken.toString()}s"
            }else{
                p0.itemView.tv_time_taken.text="Time Taken : ${timeTaken.toString().substring(0,6)}s"
            }
    }

}