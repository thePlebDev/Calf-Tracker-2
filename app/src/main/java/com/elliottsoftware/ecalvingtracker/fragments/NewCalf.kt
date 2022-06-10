package com.elliottsoftware.ecalvingtracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.elliottsoftware.ecalvingtracker.R
import com.elliottsoftware.ecalvingtracker.databinding.NewCalfBinding

class NewCalf : Fragment() {
    private var _binding: NewCalfBinding? = null

    private val binding get() = _binding!!
    private lateinit var tagNumber : EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NewCalfBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        
        binding.newCalfFabLeft.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_newCalf_to_mainFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}