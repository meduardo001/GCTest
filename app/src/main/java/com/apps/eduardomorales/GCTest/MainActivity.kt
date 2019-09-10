package com.apps.eduardomorales.GCTest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.eduardomorales.GCTest.Adapter.SearchResultsAdapter
import com.apps.eduardomorales.GCTest.Models.Movies
import com.apps.eduardomorales.GCTest.Models.RequestResult
import com.apps.eduardomorales.GCTest.Presenter.ResultPresenter
import com.apps.eduardomorales.GCTest.Views.IResultsView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IResultsView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context: Context = this
        var mLayoutManager = LinearLayoutManager(this)
        movieResults!!.layoutManager = mLayoutManager

        ResultPresenter(context).getDataFromApi()


    }

    override fun onSearchData(requestResult: RequestResult) {
        if(requestResult.movies.size > 0)
            movieResults.adapter = SearchResultsAdapter(requestResult.movies as MutableList<Movies>)
        else
            Toast.makeText(this,getString(R.string.no_results_found), Toast.LENGTH_LONG).show()
    }

    override fun onDataError(throwable: Throwable) {
        Toast.makeText(this,throwable.message, Toast.LENGTH_LONG).show()
    }

}
