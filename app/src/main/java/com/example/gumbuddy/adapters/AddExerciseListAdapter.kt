package com.example.gumbuddy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gumbuddy.databinding.ListItemExerciseBinding
import com.example.gumbuddy.db.DataSource
import com.example.gumbuddy.db.Exercise

class AddExerciseAdapter(
    val clickListener: ExerciseListener
) : ListAdapter<Exercise, AddExerciseAdapter.AddExerciseViewHolder>(DiffCallback){

    private val dataset = DataSource.exercises

    class AddExerciseViewHolder(
        var binding: ListItemExerciseBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: ExerciseListener, exercise: Exercise) {
            binding.exercise = exercise
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem.iconSrc == newItem.iconSrc && oldItem.imgSrc == newItem.imgSrc
                    && oldItem.idGroup == newItem.idGroup && oldItem.description == newItem.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddExerciseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AddExerciseViewHolder(
            ListItemExerciseBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AddExerciseViewHolder, position: Int) {
        val exercise = dataset[position]
        holder.bind(clickListener, exercise)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}

class ExerciseListener(val clickListener: (exercise: Exercise) -> Unit) {
    fun onClick(exercise: Exercise) = clickListener(exercise)
}