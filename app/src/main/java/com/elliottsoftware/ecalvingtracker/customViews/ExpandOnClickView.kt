package com.elliottsoftware.ecalvingtracker.customViews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import com.elliottsoftware.ecalvingtracker.R

class ExpandOnClickView @JvmOverloads constructor(
    context: Context,
    attrs:AttributeSet? = null,
    defStyleAttr: Int =0
) : RelativeLayout(context,attrs,defStyleAttr) {
    //private var childToCollapse: Int = 0

    init {
        isClickable = true
//        context.withStyledAttributes(attrs, R.styleable.ExpandOnClickView){
//            childToCollapse = getInt(R.styleable.ExpandOnClickView_childToCollapse,0)
//        }
    }
//
//
//
//

    override fun performClick(): Boolean {
        if (super.performClick()) return true
            this.getChildAt(4).isVisible = visibilityCheck(getChildAt(4).isVisible)
//            this.getChildAt(4).apply {
//                isVisible = visibilityCheck(isVisible)
//            }

        invalidate()
        return true
    }
//
    private fun visibilityCheck(isVisible:Boolean):Boolean{
        return !isVisible
    }



}