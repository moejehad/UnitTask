package com.moejehad.unitonetask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.moejehad.unitonetask.R
import com.moejehad.unitonetask.domain.model.AllCities

class AllCitiesAdapter(private val context: Context) :
    RecyclerView.Adapter<AllCitiesAdapter.ViewHolder>() {

    lateinit var list: List<AllCities.DataContent.City>

    fun setContentList(list: List<AllCities.DataContent.City>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image =
            itemView.findViewById<com.makeramen.roundedimageview.RoundedImageView>(R.id.all_cites_recycler_item)
        var city = itemView.findViewById<TextView>(R.id.city_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCitiesAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllCitiesAdapter.ViewHolder, position: Int) {
        Glide.with(context).load(list[position].imageURL)
            .placeholder(R.drawable.ic_launcher_background).centerCrop().into(holder.image)
        holder.city.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}