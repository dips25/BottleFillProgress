package com.anim.bottlefillanimationprogress

import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.PorterDuffXfermode
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.Xfermode
import android.graphics.drawable.ColorStateListDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var bp:BottleProgress?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bp = findViewById<BottleProgress>(R.id.bottle_progress)
        bp!!.setColors(intArrayOf(android.R.color.holo_purple
            ,android.R.color.holo_red_dark
        ,android.R.color.holo_green_light))



        val stopButton = findViewById<Button>(R.id.button_stop)

        stopButton.setOnClickListener {

            bp!!.stopAnim()
        }

        val button: Button = findViewById(R.id.button_click)
        button.setOnClickListener {

            bp!!.startAnim()
        }

    }

    override fun onResume() {
        super.onResume()
        bp!!.startAnim()
    }



    override fun onPause() {
        super.onPause()
        bp!!.stopAnim()
    }

    override fun onStop() {
        super.onStop()

        bp!!.stopAnim()
    }

}