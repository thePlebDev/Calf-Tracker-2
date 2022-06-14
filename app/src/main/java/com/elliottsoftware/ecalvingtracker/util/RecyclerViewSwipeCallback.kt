package com.elliottsoftware.ecalvingtracker.util

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.elliottsoftware.ecalvingtracker.adapters.CalfAdapter
import com.elliottsoftware.ecalvingtracker.viewModels.CalfViewModel

open class RecyclerViewSwipeCallback(
    private val dragDirs: Int,
    private val swipeDirs: Int,
    val viewModel: CalfViewModel,
    val calfAdapter: CalfAdapter
) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    /**
     * triggered on drag and drop
     * we do not care about drag and drop*/
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val calf = calfAdapter.currentList[viewHolder.adapterPosition]
        viewModel.deleteCalfOnSwipe(calf)

    }
}