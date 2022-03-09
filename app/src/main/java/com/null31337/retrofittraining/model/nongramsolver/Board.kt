package com.null31337.retrofittraining.model.nongramsolver

class Board(private val n: Int, private val m: Int = n) {
    //private val data = List(n) { 0L }

    private val data = mutableListOf(
        1000111000L,
        1000111000L,
        1000111000L,
        1000001000L,
        1000111000L,
        1000111000L,
        1000000000L,
        1000111000L,
        1011111000L,
        1000111000L,
    )

    fun getXY(x: Int, y: Int) = data[x] and (1L.shl(y))

    fun setX(x: Int) {
        data[x] = data[x]
    }

    fun setXY(x: Int, y: Int) {
        data[x] = data[x] or (1L.shl(y))
    }

    fun last() = data[n - 1]
}
