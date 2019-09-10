package com.apps.eduardomorales.GCTest.Presenter

import android.content.Context
import android.util.Log
import com.apps.eduardomorales.GCTest.API.ServiceInterface
import com.apps.eduardomorales.GCTest.Models.RequestResult
import com.apps.eduardomorales.GCTest.Views.IResultsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultPresenter(context: Context) {
    val resultsView = context as IResultsView

    fun getDataFromApi(){

        ServiceInterface.create()
            .getSearchResult()
            .enqueue(object : Callback<RequestResult> {
                override fun onFailure(call: Call<RequestResult>, t: Throwable) {
                    Log.e("ddd","error"+t.message)
                    resultsView.onDataError(t)
                }

                override fun onResponse(call: Call<RequestResult>, response: Response<RequestResult>) {
                    Log.e("fff","dadasd")
                    response.body()?.let { resultsView.onSearchData(it) }
                }

            })

    }
}