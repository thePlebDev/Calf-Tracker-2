package com.elliottsoftware.ecalvingtracker.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible

class CustomCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int =0
) : CardView(context,attrs,defStyleAttr) {
    init {
        isClickable = true
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        this.getChildAt(2).isVisible = false
        isVisible = false
        return true
    }
}