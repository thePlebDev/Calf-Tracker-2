package com.elliottsoftware.ecalvingtracker.adapters

import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.elliottsoftware.ecalvingtracker.databinding.IndivCalfBinding
import com.elliottsoftware.ecalvingtracker.models.Calf

class CalfViewHolder(private var binding: IndivCalfBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(calf:Calf){

        binding.apply {
            textViewTitle.text = calf.tagNumber
            textViewDescription.text = calf.details
            textViewDate.text = calf.date.toString()
        }
    }


}