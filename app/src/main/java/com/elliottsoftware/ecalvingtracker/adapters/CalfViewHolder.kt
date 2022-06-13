package com.elliottsoftware.ecalvingtracker.adapters

import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.elliottsoftware.ecalvingtracker.databinding.IndivCalfBinding
import com.elliottsoftware.ecalvingtracker.models.Calf
import java.text.SimpleDateFormat
import java.util.*

class CalfViewHolder(private var binding: IndivCalfBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(calf:Calf){

        //apply() is a lambda with a receiver
        binding.apply {
            this.textViewTitle.text = calf.tagNumber
            textViewDescription.text = calf.details
            textViewDate.text = dateFormatter(calf.date)
            textViewSex.text = calf.sex
            return Unit

        }
    }

    private fun dateFormatter(date: Date):String{
        val pattern:String = "yyyy-MM-dd";
        val simpleDateFormat:SimpleDateFormat = SimpleDateFormat(pattern)
        return simpleDateFormat.format(date)
    }


}