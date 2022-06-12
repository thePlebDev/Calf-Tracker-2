package com.elliottsoftware.ecalvingtracker.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.elliottsoftware.ecalvingtracker.R
import com.elliottsoftware.ecalvingtracker.database.CalfDatabaseApplication
import com.elliottsoftware.ecalvingtracker.databinding.NewCalfBinding
import com.elliottsoftware.ecalvingtracker.viewModels.CalfViewModel
import com.elliottsoftware.ecalvingtracker.viewModels.CalfViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewCalf : Fragment() {
    private var _binding: NewCalfBinding? = null

    private val binding get() = _binding!!

    private val viewModel: CalfViewModel by activityViewModels{
        CalfViewModelFactory(
            (activity?.application as CalfDatabaseApplication).database.calfDao() //providing dao for the primary constructor
        )
    }

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
        val tagNumber:EditText = binding.editTextTitle
        val details:EditText = binding.editTextDescription
        val cciaNumber:EditText = binding.editTextCciaNumber
        
        binding.newCalfFabLeft.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_newCalf_to_mainFragment)
        }


        /**
         * TODO: check if edit text is empty
         * */
        binding.newCalfFabRight.setOnClickListener {

            if(TextUtils.isEmpty(tagNumber.text.toString())){
                tagNumber.error = "Must enter tag number"

            }else{
                Snackbar.make(binding.newCalfFabRight,"Calf " + tagNumber.text + " saved",Snackbar.LENGTH_LONG)
                    .show()
                GlobalScope.launch(Dispatchers.IO){
                    viewModel.saveCalf(tagNumber.text.toString(),details.text.toString(),cciaNumber.text.toString())
                }
                //NAVIGATING BACK TO HOME PAGE

                    Navigation.findNavController(view).navigate(R.id.action_newCalf_to_mainFragment)

            }

        }


    }

    private fun addTextWatcher(tagNumber : EditText):Unit{

        tagNumber.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}