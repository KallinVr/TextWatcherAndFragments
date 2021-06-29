package com.example.textwatcherandfragments

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attrs: AttributeSet?) :
    View(context, attrs) {

    private var strokeWidth = 20f
    private var progress = 0f
    private var min = 0
    private var max = 100

    private var color = Color.parseColor("#4CAF50")
    private var rectF: RectF? = null
    private var backgroundPaint: Paint? = null
    private var textPaint: Paint? = null


    private fun init(context: Context, attrs: AttributeSet?) {
        rectF = RectF()
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            0, 0
        )


        try {
            strokeWidth = typedArray.getDimension(
                R.styleable.CustomView_CustomViewThickness,
                strokeWidth
            )
            progress = typedArray.getFloat(R.styleable.CustomView_progress, progress)
            color = typedArray.getInt(R.styleable.CustomView_CustomViewColor, color)
            min = typedArray.getInt(R.styleable.CustomView_min, min)
            max = typedArray.getInt(R.styleable.CustomView_max, max)
        } finally {
            typedArray.recycle()
        }
        backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        backgroundPaint!!.color = color
        backgroundPaint!!.style = Paint.Style.FILL
        backgroundPaint!!.strokeWidth = strokeWidth

        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint!!.color = Color.BLACK
        textPaint!!.textSize = 50.0f



    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val min = Math.min(width, height)
        setMeasuredDimension(min, min)
        rectF!![0 + strokeWidth / 2, 0 + strokeWidth / 2, min - strokeWidth / 2] =
            min - strokeWidth / 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(rectF!!, backgroundPaint!!)
        canvas.drawText("custom view", 5_0f, 150.0f, textPaint!!)
    }

    init {
        init(context, attrs)
    }
}
