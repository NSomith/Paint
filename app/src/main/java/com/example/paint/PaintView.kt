package com.example.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paint.MainActivity.Companion.paintBrush
import com.example.paint.MainActivity.Companion.path

class PaintView: View {
    var params:ViewGroup.LayoutParams? = null // height and width of canvas wrt to parent layout

    companion object{
        var pathlist = ArrayList<Path>()
        var colorlist = ArrayList<Int>()
        var currbrush = Color.BLACK
    }
    constructor(context: Context):this(context,null){
        init()
    }
    constructor(context: Context,attr:AttributeSet?):this(context,attr,0){
        init()
    }
    constructor(context: Context,attr:AttributeSet?,defStyleAttr:Int):super(context,attr,defStyleAttr)
    {
        init()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE->{
                path.lineTo(x,y)
                pathlist.add(path)
                colorlist.add(currbrush)
            }else->return false
        }
        postInvalidate() //informs the nonui thread that something has been change in the ui
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for(i in pathlist.indices){
            paintBrush.setColor(colorlist[i])
            canvas.drawPath(pathlist[i], paintBrush)
            invalidate()
        }
    }
    fun init(){
        paintBrush.isAntiAlias = true
        paintBrush.color = currbrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 8f
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}