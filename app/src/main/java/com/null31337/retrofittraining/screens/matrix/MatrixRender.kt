package com.null31337.retrofittraining.screens.matrix

import android.graphics.*

class MatrixRender {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val cubeSize = 64

    fun generateModel(canvas: Canvas) = MatrixModel(
        (canvas.width / cubeSize) + 1,
        (canvas.height / cubeSize) + 1
    )

    fun draw(canvas: Canvas, model: MatrixModel, bitmap: Bitmap) {
        paint.color = Color.BLACK;
        paint.style = Paint.Style.FILL;
        canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), paint);
        val list = model.getPoints()
        for (i in list) {
            for (j in 0..9) {
                canvas.drawBitmap(
                    bitmap,
                    getRect(i, j),
                    Rect(
                        cubeSize * i.x,
                        (cubeSize * (i.y - j)).toInt(),
                        cubeSize * (i.x + 1),
                        (cubeSize * (i.y + 1 - j)).toInt()
                    ), paint
                )
            }
        }
    }

    private fun getRect(point: Point, i: Int): Rect {
        val x: Int = (i % 4) * 512
        val y: Int = (i / 4) * 512
        val xx: Int = (point.list[i] % 8) * 64
        val yy: Int = (point.list[i] / 8) * 64
        //Log.d("TAG", "getRect: ${x + xx} + ${y + yy} + ${x + xx + 64} + ${y + yy + 64}")
        return Rect(x + xx, y + yy, x + xx + 64, y + yy + 64)
    }

}