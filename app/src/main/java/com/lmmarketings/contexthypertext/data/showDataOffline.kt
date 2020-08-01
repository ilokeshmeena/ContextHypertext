package com.lmmarketings.contexthypertext.data

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lmmarketings.contexthypertext.*

import com.lmmarketings.contexthypertext.data.json.RetrofitClient
import com.lmmarketings.contexthypertext.data.viewmodel.Result
import com.lmmarketings.contexthypertext.pages.ResultAdapterInternet
import kotlinx.android.synthetic.main.fragment_show_data.view.*
import kotlinx.android.synthetic.main.fragment_show_data_offline.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * A simple [Fragment] subclass.
 */
class showDataOffline : Fragment(),CoroutineScope {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main = inflater.inflate(R.layout.fragment_show_data_offline, container, false)
        val progressDialog = ProgressDialog(requireContext());
        progressDialog.setMessage("Please Wait.......")
        progressDialog.setCancelable(false)
        launch {
            progressDialog.show()
            data = getDataFromInternet()
            while (data == null) {
            }

            main.rvMain_internet_offline.layoutManager =
                GridLayoutManager(GetData().baseContext, 1, GridLayoutManager.VERTICAL, false)
            main.rvMain_internet_offline.adapter =ResultAdapterInternetOffline(data!!.result)
            progressDialog.hide()
        }
        return main
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    suspend fun getDataFromInternet(): Result {
        val api = RetrofitClient.getApi
        val response = api.getDatao()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            Result(result = emptyList())
        }
    }

}
