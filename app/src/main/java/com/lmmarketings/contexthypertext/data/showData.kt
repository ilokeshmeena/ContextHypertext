package com.lmmarketings.contexthypertext.data

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.lmmarketings.contexthypertext.*

import com.lmmarketings.contexthypertext.data.viewmodel.Result
import com.lmmarketings.contexthypertext.data.json.RetrofitClient
import com.lmmarketings.contexthypertext.pages.ResultAdapterInternet
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.android.synthetic.main.fragment_result.view.*
import kotlinx.android.synthetic.main.fragment_show_data.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

/**
 * A simple [Fragment] subclass.
 */
class showData : Fragment(), CoroutineScope {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main = inflater.inflate(R.layout.fragment_show_data, container, false)
        val progressDialog = ProgressDialog(requireContext());
        progressDialog.setMessage("Please Wait.......")
        progressDialog.setCancelable(false)
            launch {
                progressDialog.show()
                data = getDataFromInternet()
                while (data == null) {
                }
                dataLength = data!!.result.size
                current=0
                val noOfTransitionsInternet = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                val timeTakenInternet = DoubleArray(9)
                noOfTransitionsInternet[1] = data!!.result[0].transition1
                timeTakenInternet[1] = data!!.result[0].time1.toDouble()

                noOfTransitionsInternet[2] = data!!.result[0].transition2
                timeTakenInternet[2] = data!!.result[0].time2.toDouble()

                noOfTransitionsInternet[3] = data!!.result[0].transition3
                timeTakenInternet[3] = data!!.result[0].time3.toDouble()

                noOfTransitionsInternet[4] = data!!.result[0].transition4
                timeTakenInternet[4] = data!!.result[0].time4.toDouble()

                noOfTransitionsInternet[5] = data!!.result[0].transition5
                timeTakenInternet[5] = data!!.result[0].time5.toDouble()

                noOfTransitionsInternet[6] = data!!.result[0].transition6
                timeTakenInternet[6] = data!!.result[0].time6.toDouble()

                noOfTransitionsInternet[7] = data!!.result[0].transition7
                timeTakenInternet[7] = data!!.result[0].time7.toDouble()

                noOfTransitionsInternet[8] = data!!.result[0].transition8
                timeTakenInternet[8] = data!!.result[0].time8.toDouble()
                var average_time = 0.0
                for (x in 1..8) {
                    average_time += timeTakenInternet[x]
                }
                main.tv_result_no.text="Result : 1"
                if(average_time.toString().length<=6){
                    main.tv_average_time_internet.text = "Average time: ${(average_time / 8).toString()} s"
                }else{
                    main.tv_average_time_internet.text="Average Time : ${(average_time.toDouble()/8).toString().substring(0,6)} s"
                }
                main.tv_average_transition_internet.text =
                    "Average transition : " + ((data!!.result[0].averageTransition.toDouble())/8).toString()
                main.tv_time_taken_eyes_internet.text =
                    "Eye fixation : " + data!!.result[0].eyeFixation +" ms"
                main.rvMain_internet.layoutManager =
                    GridLayoutManager(GetData().baseContext, 3, GridLayoutManager.HORIZONTAL, false)
                main.rvMain_internet.adapter =
                    ResultAdapterInternet(noOfTransitionsInternet, timeTakenInternet)
                progressDialog.hide()
            }
        main.next_result.setOnClickListener {
            if(current!! <= dataLength!!-2){
                current= current!!+1
                progressDialog.show()
                val noOfTransitionsInternet = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                val timeTakenInternet = DoubleArray(9)
                noOfTransitionsInternet[1] = data!!.result[current!!].transition1
                timeTakenInternet[1] = data!!.result[current!!].time1.toDouble()

                noOfTransitionsInternet[2] = data!!.result[current!!].transition2
                timeTakenInternet[2] = data!!.result[current!!].time2.toDouble()

                noOfTransitionsInternet[3] = data!!.result[current!!].transition3
                timeTakenInternet[3] = data!!.result[current!!].time3.toDouble()

                noOfTransitionsInternet[4] = data!!.result[current!!].transition4
                timeTakenInternet[4] = data!!.result[current!!].time4.toDouble()

                noOfTransitionsInternet[5] = data!!.result[current!!].transition5
                timeTakenInternet[5] = data!!.result[current!!].time5.toDouble()

                noOfTransitionsInternet[6] = data!!.result[current!!].transition6
                timeTakenInternet[6] = data!!.result[current!!].time6.toDouble()

                noOfTransitionsInternet[7] = data!!.result[current!!].transition7
                timeTakenInternet[7] = data!!.result[current!!].time7.toDouble()

                noOfTransitionsInternet[8] = data!!.result[current!!].transition8
                timeTakenInternet[8] = data!!.result[current!!].time8.toDouble()
                var average_time = 0.0
                for (x in 1..8) {
                    average_time += timeTakenInternet[x]
                }
                main.tv_result_no.text ="Result : "+ (current!! +1).toString()
                if(average_time.toString().length<=6){
                    main.tv_average_time_internet.text = "Average time: ${(average_time / 8).toString()} s"
                }else{
                    main.tv_average_time_internet.text="Average Time : ${(average_time.toDouble()/8).toString().substring(0,6)} s"
                }
                main.tv_average_transition_internet.text =
                    "Average transition : " + ((data!!.result[current!!].averageTransition.toDouble())/8).toString()
                main.tv_time_taken_eyes_internet.text =
                    "Eye fixation : " + data!!.result[current!!].eyeFixation+" ms"
                main.rvMain_internet.layoutManager =
                    GridLayoutManager(GetData().baseContext, 3, GridLayoutManager.HORIZONTAL, false)
                main.rvMain_internet.adapter =
                    ResultAdapterInternet(noOfTransitionsInternet, timeTakenInternet)
                progressDialog.hide()
            }else{
             Toast.makeText(requireContext(),"You're on last page",Toast.LENGTH_SHORT).show()
            }
        }
        main.previous_result.setOnClickListener {
            if(current!! >= 1){
                current= current!!-1
                progressDialog.show()
                val noOfTransitionsInternet = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                val timeTakenInternet = DoubleArray(9)
                noOfTransitionsInternet[1] = data!!.result[current!!].transition1
                timeTakenInternet[1] = data!!.result[current!!].time1.toDouble()

                noOfTransitionsInternet[2] = data!!.result[current!!].transition2
                timeTakenInternet[2] = data!!.result[current!!].time2.toDouble()

                noOfTransitionsInternet[3] = data!!.result[current!!].transition3
                timeTakenInternet[3] = data!!.result[current!!].time3.toDouble()

                noOfTransitionsInternet[4] = data!!.result[current!!].transition4
                timeTakenInternet[4] = data!!.result[current!!].time4.toDouble()

                noOfTransitionsInternet[5] = data!!.result[current!!].transition5
                timeTakenInternet[5] = data!!.result[current!!].time5.toDouble()

                noOfTransitionsInternet[6] = data!!.result[current!!].transition6
                timeTakenInternet[6] = data!!.result[current!!].time6.toDouble()

                noOfTransitionsInternet[7] = data!!.result[current!!].transition7
                timeTakenInternet[7] = data!!.result[current!!].time7.toDouble()

                noOfTransitionsInternet[8] = data!!.result[current!!].transition8
                timeTakenInternet[8] = data!!.result[current!!].time8.toDouble()
                var average_time = 0.0
                for (x in 1..8) {
                    average_time += timeTakenInternet[x]
                }
                main.tv_result_no.text ="Result : "+ (current!! +1).toString()
                if(average_time.toString().length<=6){
                    main.tv_average_time_internet.text = "Average time: ${(average_time / 8).toString()} s"
                }else{
                    main.tv_average_time_internet.text="Average Time : ${(average_time.toDouble()/8).toString().substring(0,6)} s"
                }
                main.tv_average_transition_internet.text =
                    "Average transition : " + ((data!!.result[current!!].averageTransition.toDouble())/8).toString()
                main.tv_time_taken_eyes_internet.text =
                    "Eye fixation : " + data!!.result[current!!].eyeFixation+" ms"
                main.rvMain_internet.layoutManager =
                    GridLayoutManager(GetData().baseContext, 3, GridLayoutManager.HORIZONTAL, false)
                main.rvMain_internet.adapter =
                    ResultAdapterInternet(noOfTransitionsInternet, timeTakenInternet)
                progressDialog.hide()
            }else{
                Toast.makeText(requireContext(),"You're on first page",Toast.LENGTH_SHORT).show()
            }
        }
        return main
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    suspend fun getDataFromInternet(): Result {
        val api = RetrofitClient.getApi
        val response = api.getDatam()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            Result(result = emptyList())
        }
    }

}
