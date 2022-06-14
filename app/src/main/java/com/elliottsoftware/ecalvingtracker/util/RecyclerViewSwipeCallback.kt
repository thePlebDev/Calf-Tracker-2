package com.elliottsoftware.ecalvingtracker.util

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewSwipeCallback(dragDirs: Int,
                                swipeDirs: Int
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
        TODO("Not yet implemented")
    }
}