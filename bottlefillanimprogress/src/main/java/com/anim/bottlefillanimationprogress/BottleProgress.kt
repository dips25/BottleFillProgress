package com.anim.bottlefillanimationprogress

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import java.util.Collections

class BottleProgress:FrameLayout {

    lateinit var v: View

    lateinit var bottle1:Bottle
    lateinit var bottle2:Bottle
    lateinit var bottle3:Bottle
    lateinit var c:Context

    var DURATION = 1000
    var TYPE = 0
    var WATER_COLOR:Int = 0
    var colorArr:IntArray = IntArray(0)

    constructor(c:Context) : super(c) {

        this.c = c


    }

    constructor(c:Context,a:AttributeSet) : super(c,a) {

        this.c = c

        val t:TypedArray = c.obtainStyledAttributes(a,R.styleable.BottleProgress)

        DURATION = t.getInt(R.styleable.BottleProgress_duration , 1000)
        TYPE = t.getInt(R.styleable.BottleProgress_type,0)
        WATER_COLOR = t.getInt(R.styleable.BottleProgress_waterColor
            ,0)


        init(this)


    }

    constructor(c:Context,a:AttributeSet,defStyle:Int) : super(c,a,defStyle) {

        this.c = c

        val t:TypedArray = c.obtainStyledAttributes(a,R.styleable.BottleProgress)

        DURATION = t.getInt(R.styleable.BottleProgress_duration , 1000)
        TYPE = t.getInt(R.styleable.BottleProgress_type,0)
        WATER_COLOR = t.getInt(R.styleable.BottleProgress_waterColor
            ,0)



        init(this)


    }

    private fun init(f:FrameLayout) {

        v = LayoutInflater.from(this.c)
            .inflate(R.layout.layout_bottles,f,true)

        bottle1 = v.findViewById(R.id.bottle1)
        bottle2 = v.findViewById(R.id.bottle2)
        bottle3 = v.findViewById(R.id.bottle3)




    }

    fun setColors(cArray:IntArray) {

        this.colorArr = cArray


    }

    fun startAnim() {

        if (TYPE == 0) {

            if (colorArr!!.size<3) {

                bottle1.startFillAnimation(100,DURATION.toLong() , android.R.color.holo_blue_light)
                bottle2.startFillAnimation(100,DURATION.toLong() , android.R.color.holo_blue_light)
                bottle3.startFillAnimation(100,DURATION.toLong() , android.R.color.holo_blue_light)


            } else {

                bottle1.startFillAnimation(100,DURATION.toLong() , colorArr.get(0))
                bottle2.startFillAnimation(100,DURATION.toLong() , colorArr.get(1))
                bottle3.startFillAnimation(100,DURATION.toLong() , colorArr.get(2))

            }





        } else if (TYPE == 1) {

            if (colorArr!!.size<3) {

                bottle1.startFillAnimation(100,DURATION.toLong() , android.R.color.holo_blue_light)
                bottle2.startFillAnimation(200,DURATION.toLong() , android.R.color.holo_blue_light)
                bottle3.startFillAnimation(300,DURATION.toLong() , android.R.color.holo_blue_light)


            } else {

                bottle1.startFillAnimation(100,DURATION.toLong() , colorArr.get(0))
                bottle2.startFillAnimation(200,DURATION.toLong() , colorArr.get(1))
                bottle3.startFillAnimation(300,DURATION.toLong() , colorArr.get(2))

            }

        } else if (TYPE == 2) {

            var l = mutableListOf(100,200,300)
            Collections.shuffle(l)

            if (colorArr!!.size<3) {

                bottle1.startFillAnimation(l.get(0).toLong(),DURATION.toLong() , android.R.color.holo_blue_light)
                bottle2.startFillAnimation(l.get(1).toLong(),DURATION.toLong() , android.R.color.holo_blue_light)
                bottle3.startFillAnimation(l.get(2).toLong(),DURATION.toLong() , android.R.color.holo_blue_light)


            } else {

                bottle1.startFillAnimation(l.get(0).toLong(),DURATION.toLong() , colorArr.get(0))
                bottle2.startFillAnimation(l.get(1).toLong(),DURATION.toLong() , colorArr.get(1))
                bottle3.startFillAnimation(l.get(2).toLong(),DURATION.toLong() , colorArr.get(2))

            }

        }

    }

    fun stopAnim() {

        bottle1.stopAnim()
        bottle2.stopAnim()
        bottle3.stopAnim()

//        animator.cancel()
//        isResume = false
//        isProgress = false
//        isFinish = false

    }
}