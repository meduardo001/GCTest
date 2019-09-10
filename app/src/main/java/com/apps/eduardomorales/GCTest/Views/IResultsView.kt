package com.apps.eduardomorales.GCTest.Views

import com.apps.eduardomorales.GCTest.Models.RequestResult

interface IResultsView {
    fun onSearchData(requestResult: RequestResult)
    fun onDataError(throwable: Throwable)
}