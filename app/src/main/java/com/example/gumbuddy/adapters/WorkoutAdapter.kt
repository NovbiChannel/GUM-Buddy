package com.example.gumbuddy.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gumbuddy.databinding.ListItemExerciseBinding
import com.example.gumbuddy.databinding.ListItemTrainingListBinding
import com.example.gumbuddy.db.Exercise
import com.example.gumbuddy.ui.viewmodels.MainViewModel

class WorkoutAdapter(private val clickListener: (Exercise) -> Unit) :
    ListAdapter<Exercise, WorkoutAdapter.WorkoutViewHolder>(DiffCallback){

    private lateinit var context: Context

    class WorkoutViewHolder(private var binding: ListItemTrainingListBinding
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
                    oldItem.iconSrc == newItem.iconSrc || oldItem.imgSrc == newItem.imgSrc ||
                    oldItem.checkExercise == newItem.checkExercise)
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkoutViewHolder {
        context = parent.context
        return WorkoutViewHolder(
            ListItemTrainingListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    //При нажатии на айтем мы получаем все данные его сущности
    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val exercise = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener(exercise)
        }
        holder.bind(exercise)
    }
}