package com.elliottsoftware.ecalvingtracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elliottsoftware.ecalvingtracker.databinding.IndivCalfBinding
import com.elliottsoftware.ecalvingtracker.models.Calf

class CalfAdapter(private val onItemClicked:(Calf)->Unit):ListAdapter<Calf,CalfViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalfViewHolder{
        val viewHolder = CalfViewHolder(
            IndivCalfBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder

    }
    override fun onBindViewHolder(holder: CalfViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Calf>() {
            override fun areItemsTheSame(oldItem: Calf, newItem: Calf): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Calf, newItem: Calf): Boolean {
                return oldItem == newItem
            }
        }
    }
}