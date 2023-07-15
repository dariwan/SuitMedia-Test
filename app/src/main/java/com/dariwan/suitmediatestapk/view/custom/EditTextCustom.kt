package com.dariwan.suitmediatestapk.view.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.dariwan.suitmediatestapk.R

class EditTextCustom: AppCompatEditText {
    private lateinit var buttonBackground: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = buttonBackground
    }

    private fun init() {
        buttonBackground = ContextCompat.getDrawable(context, R.drawable.bg_edit_text) as Drawable

    }
}