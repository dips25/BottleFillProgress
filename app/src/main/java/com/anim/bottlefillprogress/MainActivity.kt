package com.anim.bottlefillprogress

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.anim.bottlefillanimationprogress.BottleProgress
import com.anim.bottlefillanimationprogress.R

class MainActivity : AppCompatActivity() {
    var bp: BottleProgress?=null

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

        //set the colors(default blue)
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

        //start when needed
        bp!!.startAnim()
    }



    override fun onPause() {
        super.onPause()

        //stop when not needed(onPause())
        bp!!.stopAnim()
    }

    override fun onStop() {
        super.onStop()

        //stop when not needed(onStop)
        bp!!.stopAnim()
    }
}