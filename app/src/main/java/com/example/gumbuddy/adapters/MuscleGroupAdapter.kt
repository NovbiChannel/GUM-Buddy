package com.example.gumbuddy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gumbuddy.R
import com.example.gumbuddy.db.DataSource

class MuscleGroupAdapter : RecyclerView.Adapter<MuscleGroupAdapter.MuscleGroupViewHolder>() {

    private val dataset = DataSource.groups

    class MuscleGroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView = view.findViewById(R.id.iv_muscle_group)
        val tvName: TextView = view.findViewById(R.id.tv_muscle_group)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuscleGroupViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_muscle_group, parent, false)
        return MuscleGroupViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MuscleGroupViewHolder, position: Int) {

        val item = dataset[position]

        holder.imgView.setImageResource(item.imgSrc)
        holder.tvName.text = item.name
    }

    override fun getItemCount(): Int{
        return dataset.size
    }
}