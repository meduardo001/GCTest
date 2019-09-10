package com.apps.eduardomorales.GCTest.API

import com.apps.eduardomorales.GCTest.Models.RequestResult
import com.apps.eduardomorales.GCTest.Tools.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceInterface {

    @GET("movies/categories")
    fun getSearchResult() : Call<RequestResult>

    companion object {
        fun create(): ServiceInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.API_URL)
                .build()

            return retrofit.create(ServiceInterface::class.java)
        }
    }
}