package com.example.gumbuddy.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gumbuddy.databinding.ListItemMuscleGroupBinding
import com.example.gumbuddy.db.MuscleGroup
import com.example.gumbuddy.ui.viewmodels.MainViewModel

class MuscleGroupListAdapter(private val clickListener: (MuscleGroup) -> Unit) :
    ListAdapter<MuscleGroup, MuscleGroupListAdapter.MuscleGroupViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class MuscleGroupViewHolder(private var binding: ListItemMuscleGroupBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(group: MuscleGroup) {
            // Load the images into the ImageView using the Coil library.
            binding.ivMuscleGroup.load(group.imgSrc)
            binding.tvMuscleGroup.text = group.name
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<MuscleGroup>() {
        override fun areItemsTheSame(oldItem: MuscleGroup, newItem: MuscleGroup): Boolean {
            return (oldItem.id == newItem.id || oldItem.name == newItem.name ||
                    oldItem.imgSrc == newItem.imgSrc)
        }

        override fun areContentsTheSame(oldItem: MuscleGroup, newItem: MuscleGroup): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MuscleGroupViewHolder {
        context = parent.context
        return MuscleGroupViewHolder(
            ListItemMuscleGroupBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MuscleGroupViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener(current)
            Log.d("MyTag", "${current.id}")
        }
        holder.bind(current)
    }
}