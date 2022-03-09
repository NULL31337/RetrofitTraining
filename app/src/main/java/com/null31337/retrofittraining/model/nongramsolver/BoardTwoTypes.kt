package com.null31337.retrofittraining.model.nongramsolver

class BoardTwoTypes(private val n: Int, private val m: Int) {
    private val usedBoard = Board(n, m)
    private val unusedBoard = Board(n, m)

    internal fun setXY(x: Int, y: Int, isFill: Boolean) = when (isFill) {
        true -> usedBoard.setXY(x, y)
        else -> unusedBoard.setXY(x, y)
    }

    internal fun setX(x: Int, isFill: Boolean) = when (isFill) {
        true -> usedBoard.setX(x)
        else -> unusedBoard.setX(x)
    }

    internal fun isEnd() = usedBoard.last() or unusedBoard.last() == (1L.shl(m) - 1)
}