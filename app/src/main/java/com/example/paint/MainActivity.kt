package com.example.paint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.paint.PaintView.Companion.colorlist
import com.example.paint.PaintView.Companion.currbrush
import com.example.paint.PaintView.Companion.pathlist

class MainActivity : AppCompatActivity() {
    companion object{
        var path = Path()
        var paintBrush = Paint()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val redbtn = findViewById<ImageButton>(R.id.redColor)
        val bluebtn = findViewById<ImageButton>(R.id.blueColor)
        val blackbtn = findViewById<ImageButton>(R.id.blackColor)
        val erase = findViewById<ImageButton>(R.id.whiteColor)


        redbtn.setOnClickListener {
            paintBrush.color = Color.RED
            currbrush = Color.RED
            path = Path()
        }
        bluebtn.setOnClickListener {
            paintBrush.color = Color.BLUE
            currbrush = Color.BLUE
            path = Path()

        }
        blackbtn.setOnClickListener {
            paintBrush.color = Color.BLACK
            currbrush = Color.BLACK
            path = Path()

        }
        erase.setOnClickListener {
            pathlist.clear()
            colorlist.clear()
            path.reset()
            
        }
    }
}