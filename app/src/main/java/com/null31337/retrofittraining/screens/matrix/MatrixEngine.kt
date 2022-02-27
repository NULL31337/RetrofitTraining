package com.null31337.retrofittraining.screens.matrix

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.null31337.retrofittraining.R
import kotlinx.coroutines.*


class MatrixEngine(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback {
    private var model: MatrixModel? = null
    private var bitmap : Bitmap
    private var render: MatrixRender = MatrixRender()
    private var drawingJob: Job? = null

    var time = System.nanoTime()


    constructor(context: Context): this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet): this(context, attrs, 0)

    init {
        holder.addCallback(this)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.matrix_sprites)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        drawingJob = CoroutineScope(Dispatchers.IO).launch {
            while (isActive) {
                val canvas = holder.lockCanvas() ?: continue
                try {
                    synchronized(holder) {
                        val timeElapsed = System.nanoTime() - time
                        time = System.nanoTime()
                        if (model == null) {
                            model = render.generateModel(canvas)
                        }
                        model!!.update(timeElapsed)
                        render.draw(canvas, model!!, bitmap)
                    }
                } finally {
                    holder.unlockCanvasAndPost(canvas)
                }
            }
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        runBlocking {
            drawingJob?.cancelAndJoin()
        }
    }
}