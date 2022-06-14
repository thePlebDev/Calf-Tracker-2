package com.elliottsoftware.ecalvingtracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.elliottsoftware.ecalvingtracker.databinding.MainFragmentBinding

open class ViewBindingFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null

    protected val binding get() = _binding!! //THIS IS A GETTER??


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


    //used to remove the reference to the view so it can be garbage collected
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}