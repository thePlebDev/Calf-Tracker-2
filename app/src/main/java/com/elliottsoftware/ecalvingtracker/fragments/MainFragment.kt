package com.elliottsoftware.ecalvingtracker.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elliottsoftware.ecalvingtracker.R
import com.elliottsoftware.ecalvingtracker.adapters.CalfAdapter
import com.elliottsoftware.ecalvingtracker.database.CalfDatabaseApplication
import com.elliottsoftware.ecalvingtracker.databinding.MainFragmentBinding
import com.elliottsoftware.ecalvingtracker.util.RecyclerViewSwipeCallback
import com.elliottsoftware.ecalvingtracker.viewModels.CalfViewModel
import com.elliottsoftware.ecalvingtracker.viewModels.CalfViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainFragment : ViewBindingFragment() {



    private lateinit var recyclerView: RecyclerView

    private val viewModel: CalfViewModel by activityViewModels{
        CalfViewModelFactory(
            (activity?.application as CalfDatabaseApplication).database.calfDao() //providing dao for the primary constructor
        )
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //SETTING UP THE RECYCLER VIEW
        val calfAdapters = CalfAdapter {
            //This lambda will be called when the recyclerView items are clicked

        }
        binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = calfAdapters
            }

            setUpItemTouchHelper(viewModel,calfAdapters)
                .attachToRecyclerView(recyclerView)



        }



        lifecycle.coroutineScope.launch{
            viewModel.allCalves().collect {
                calfAdapters.submitList(it)
            }
        }


        //SETTING THE F.A.B NAVIGATION
        binding.fabAddCalf.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_newCalf)
        }

    }

    private fun setUpItemTouchHelper(viewModel: CalfViewModel,calfAdapters: CalfAdapter): ItemTouchHelper{
        return ItemTouchHelper(RecyclerViewSwipeCallback(0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
            viewModel,
            calfAdapters
        ))

    }
    

}