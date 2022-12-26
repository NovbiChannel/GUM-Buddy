package com.example.gumbuddy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gumbuddy.databinding.ListItemExerciseBinding
import com.example.gumbuddy.db.Exercise

class AddExerciseAdapter(private val clickListener: (Exercise) -> Unit) :
    ListAdapter<Exercise, AddExerciseAdapter.AddExerciseViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class AddExerciseViewHolder(private var binding: ListItemExerciseBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: Exercise) {
            // Load the images into the ImageView using the Coil library.
            binding.ivExerciseIcon.load(exercise.iconSrc)
            binding.tvExerciseName.text = exercise.name
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return (oldItem.id == newItem.id || oldItem.idGroup == newItem.idGroup ||
                    oldItem.name == newItem.name || oldItem.description == newItem.description ||
                    oldItem.iconSrc == newItem.iconSrc || oldItem.imgSrc == newItem.imgSrc)
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AddExerciseViewHolder {
        context = parent.context
        return AddExerciseViewHolder(
            ListItemExerciseBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AddExerciseViewHolder, position: Int) {
        val exercise = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener(exercise)
        }
        holder.bind(exercise)
    }
}