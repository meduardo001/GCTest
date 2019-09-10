package com.apps.eduardomorales.GCTest.Models

import com.google.gson.annotations.SerializedName

data class RequestResult (
    @SerializedName("id") val id : Int,
    @SerializedName("category") val category : String,
    @SerializedName("color") val color : String,
    @SerializedName("status") val status : Int,
    @SerializedName("movies") val movies : List<Movies>
)