package com.example.gumbuddy.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gumbuddy.db.Exercise

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Exercise>?) {
    val adapter = recyclerView.adapter as AddExerciseAdapter
    adapter.submitList(data)
}