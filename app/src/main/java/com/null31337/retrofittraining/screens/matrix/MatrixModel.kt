package com.null31337.retrofittraining.screens.matrix

import kotlin.random.Random
import kotlin.random.nextInt

class MatrixModel(private val maxX: Int, private val maxY: Int) {
    private val maxSize = 30
    private val list = Array(maxSize) {
        Point(
            Random.nextInt(0..maxX),
            Random.nextInt(-30..0).toLong()
        )
    }
    private val updateEvery = 100000000L

    fun update(timeElapsed: Long) {
        for (i in list) {
            var prev = i.y
            i.y += (timeElapsed + i.prevTime) / updateEvery
            i.prevTime = (timeElapsed + i.prevTime) % updateEvery
            prev -= i.y
            while (prev < 0) {
                prev++
                i.list.remove(i.list.first())
                i.list.add(Random.nextInt(63))
            }
            if (i.y > maxY) {
                i.x = Random.nextInt(0..maxX)
                i.y = Random.nextInt(-30..0).toLong()
            }
        }
    }

    fun getPoints(): Array<Point> = list
}

