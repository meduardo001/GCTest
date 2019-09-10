package com.apps.eduardomorales.GCTest.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.apps.eduardomorales.GCTest.Models.Movies
import com.apps.eduardomorales.GCTest.R


class SearchResultsAdapter (private val results: MutableList<Movies>):
    RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            SearchResultsAdapter.ViewHolder {

        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.search_results,parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: SearchResultsAdapter.ViewHolder, position: Int) {

        holder.movieName.text = results[position].title
        holder.subtitle.text = results[position].subtitle
        holder.description.text = results[position].description


    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal val movieName: TextView

        internal val subtitle: TextView
        internal val description: TextView


        init {
            movieName = view.findViewById(R.id.movieName)

            subtitle = view.findViewById(R.id.subtitle)
            description = view.findViewById(R.id.description)

        }
    }
}