package com.anim.bottlefillanimationprogress

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View

class Bottle: View {

    lateinit var b: Bitmap
    lateinit var drawCanvas: Canvas

    var startX = 0f
    var startY = 0f

    var mWidth = 0f
    var mHeight = 0f

    var topEdge = 0f

    var upperTopX = 0f

    var upperTopY = 0f

    var bottom = 0f

    var bottomRight = 0f

    var mtopEdge = 0f

    var mupperTopX = 0f

    var mupperTopY = 0f

    var mbottom = 0f

    var mbottomRight = 0f

    var fStartX = 0f
    var fStartY = 0f

    lateinit var  dsp: DisplayMetrics;

    lateinit var path: Path;
    lateinit var fillPath:Path

    lateinit var p: Paint
    lateinit var fillPaint:Paint

    var DELAY:Long = 0
    var DURATION:Long = 1000
    var WATER_COLOR:Int = android.R.color.holo_blue_light

    private constructor(c: Context) : super(c) {


    }

    constructor(c: Context, a: AttributeSet) : super(c, a) {

        path = Path()
        fillPath = Path()

        p = Paint()
        p.isAntiAlias = true
        p.style = Paint.Style.STROKE
        p.strokeCap = Paint.Cap.ROUND
        p.strokeWidth = 8f

        fillPaint = Paint()

        fillPaint.isAntiAlias = true
        fillPaint.style = Paint.Style.FILL
        fillPaint.color = Color.CYAN


    }

    constructor(c: Context, a: AttributeSet, defstyle: Int) : super(c, a, defstyle) {

        path = Path()
        fillPath = Path()

        p = Paint()
        p.isAntiAlias = true
        p.style = Paint.Style.STROKE
        p.strokeCap = Paint.Cap.ROUND
        p.strokeWidth = 10f

        fillPaint = Paint()

        fillPaint.isAntiAlias = true
        fillPaint.style = Paint.Style.FILL
        fillPaint.color = Color.CYAN


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        dsp = resources.displayMetrics

        mWidth = dsp.widthPixels.toFloat()
        mHeight = dsp.heightPixels.toFloat()

         startX = mWidth*0.05f
         startY = 15f

         p.strokeWidth = mWidth*0.0085f

        topEdge = mWidth * 0.03f

        upperTopX = mWidth * 0.03f

        upperTopY = mWidth * 0.06f

        bottom = mWidth * 0.11f

        bottomRight = mWidth * 0.08422f

        setMeasuredDimension(
            resolveSize(bottomRight.toInt() + (mWidth*0.03).toInt(), widthMeasureSpec),
            resolveSize(bottom.toInt() + (mWidth*0.09).toInt(), heightMeasureSpec)
        )
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(b)

        setValues()


        //start
        path.moveTo(startX.toFloat(), startY.toFloat())

        //start-up
        path.lineTo(startX, startY + topEdge)

        //left-upper
        path.lineTo(startX - upperTopX, startY + upperTopY)

        //down
        path.lineTo(startX - upperTopX, startY + upperTopY + bottom)

        //right-bottom
        path.lineTo(startX - upperTopX + bottomRight, startY + upperTopY + bottom)

        //right-up
        path.lineTo(startX - upperTopX + bottomRight, startY + upperTopY)


        //right-upper
        path.lineTo((startX - upperTopX + bottomRight) - upperTopX, startY + topEdge)


        //start
        path.lineTo((startX - upperTopX + bottomRight) - upperTopX, startY)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)



        if (!isProgress) {

            drawCanvas.drawPath(path, p)
            drawCanvas.clipPath(fillPath)


        } else {

            //drawCanvas.drawPath(path, p)
            //drawCanvas.clipPath(fillPath)


            if (!isFinish) {

                drawCanvas.drawRect(
                    0f, rectTop, b!!.width.toFloat(), b!!.height.toFloat(), fillPaint
                )


            } else {

                drawCanvas.drawColor(Color.WHITE)
                isFinish = false
                //animator.cancel()
                animator.start()

            }

        }

        if (!isResume) {

            drawCanvas.drawColor(Color.WHITE)
        }


        canvas.drawBitmap(b, 0f, 0f, null)
    }

    var animatedValue = 0f
    var isProgress = false
    var isFinish = false
    var rectTop = 0f

    lateinit var animator: ValueAnimator

    fun startFillAnimation(startDelay: Long = 100, duration: Long = 1000 , color:Int =android.R.color.holo_blue_light) {

        if (!isResume) {

            isResume = true

            DELAY = startDelay
            DURATION = duration
            WATER_COLOR = color

            fillPaint.color = resources.getColor(WATER_COLOR)

            animator = ValueAnimator.ofFloat(0f, 1f)
            animator.duration = duration
            animator.startDelay = startDelay
            animator.addUpdateListener { animation ->

                isProgress = true
                animatedValue = animation.animatedValue as Float



                rectTop = b!!.height * (1 - animatedValue)








//            val sc = c!!.saveLayer(0f, 0f, b!!.width.toFloat()
//                , b!!.height.toFloat(), null)

                //c!!.restoreToCount(sc)



                if (animatedValue == 1f) {

                    isFinish = true

                }

                invalidate()

            }
            animator.start()

        }


    }

    private fun setValues() {

        mtopEdge = mWidth*0.03f

        mupperTopX = (mWidth*0.03f)-1

        mupperTopY = mWidth*0.06f

        mbottom = (mWidth*0.11f)-1f

        mbottomRight = (mWidth*0.0810f)

        fStartX = startX+1
        fStartY = startY


        //start
        fillPath.moveTo(fStartX, fStartY)

        //start-up
        fillPath.lineTo(fStartX,fStartY+mtopEdge)


       //left-upper
        fillPath.lineTo(fStartX-mupperTopX, fStartY+mupperTopY)


//        //down
        fillPath.lineTo(fStartX-mupperTopX, fStartY+mupperTopY+mbottom)


//        //right-bottom
        fillPath.lineTo(fStartX-mupperTopX+mbottomRight, fStartY+mupperTopY+mbottom)


//        //right-up
        fillPath.lineTo(fStartX-mupperTopX+mbottomRight , fStartY+mupperTopY)


//        //right-upper
        fillPath.lineTo((fStartX-mupperTopX+mbottomRight-mupperTopX)-1f , fStartY+mtopEdge)


//        start
        fillPath.lineTo((fStartX-mupperTopX+mbottomRight-mupperTopX)-1f , fStartY)

    }

    var isResume = false

    override fun onSaveInstanceState(): Parcelable? {

        val superstate = super.onSaveInstanceState()

        val bundle = Bundle()
        bundle.putParcelable("superstate",superstate)
        bundle.putLong("delay",DELAY)
        bundle.putLong("duration",DURATION)
        bundle.putInt("color",WATER_COLOR)
        bundle.putBoolean("isProgress",isProgress)

        if (isProgress) {

            animator.pause()
            isResume = true
            bundle.putBoolean("isResume",isResume)

        }

        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {

        if (state is Bundle) {

            //rectTop = state.getFloat("progress",0f)
            DELAY = state.getLong("delay",DELAY)
            DURATION = state.getLong("duration",DURATION)
            WATER_COLOR = state.getInt("color",WATER_COLOR)
            isResume = state.getBoolean("isResume")

            super.onRestoreInstanceState(state.getParcelable("superstate"))

            Handler().post {

                isProgress = state.getBoolean("isProgress")

                if (isProgress) {

                    isResume = false

                    isProgress = true
                    startFillAnimation(DELAY,DURATION,WATER_COLOR)

                }

            }

        } else {

            super.onRestoreInstanceState(state)
            if (isProgress) {

                startFillAnimation(DELAY,DURATION,WATER_COLOR)

            }

        }

    }

    fun stopAnim() {

        animator.cancel()
        isResume = false
        isProgress = false
        isFinish = false

        invalidate()

    }

}