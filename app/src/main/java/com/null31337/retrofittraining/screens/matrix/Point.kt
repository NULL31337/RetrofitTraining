package com.null31337.retrofittraining.screens.matrix

import java.util.*
import kotlin.random.Random

data class Point(
    var x: Int,
    var y: Long = 0,
    var prevTime: Long = 0L,
    val list: MutableList<Int> = MutableList(10) { Random.nextInt(63) }
)
