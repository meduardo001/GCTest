package com.apps.eduardomorales.GCTest.Models

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("subtitle") val subtitle : String,
    @SerializedName("year") val year : Int,
    @SerializedName("description") val description : String,
    @SerializedName("status") val status : Int,
    @SerializedName("idCategory") val idCategory : Int
)