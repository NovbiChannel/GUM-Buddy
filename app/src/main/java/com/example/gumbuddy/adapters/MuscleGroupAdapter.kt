package com.example.gumbuddy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gumbuddy.R
import com.example.gumbuddy.databinding.ListItemMuscleGroupBinding
import com.example.gumbuddy.db.DataSource
import com.example.gumbuddy.db.MuscleGroup
import com.example.gumbuddy.ui.fragments.MuscleGroupsFragment
import com.example.gumbuddy.ui.fragments.WorkoutFragment

class MuscleGroupAdapter(
    val clickListener: GroupListener
) : RecyclerView.Adapter<MuscleGroupAdapter.MuscleGroupViewHolder>() {

    private val dataset = DataSource.groups

    class MuscleGroupViewHolder(
        var binding: ListItemMuscleGroupBinding
        ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: GroupListener, group: MuscleGroup) {
            binding.group = group
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        val imgView = binding.ivMuscleGroup
        val tvName = binding.tvMuscleGroup
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuscleGroupViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MuscleGroupViewHolder(
            ListItemMuscleGroupBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MuscleGroupViewHolder, position: Int) {

        val item = dataset[position]

        holder.imgView.setImageResource(item.imgSrc)
        holder.tvName.text = item.name
        holder.bind(clickListener, item)
    }

    override fun getItemCount(): Int{
        return dataset.size
    }
}

class GroupListener(val clickListener: (group: MuscleGroup) -> Unit) {
    fun onClick(group: MuscleGroup) = clickListener(group)
}