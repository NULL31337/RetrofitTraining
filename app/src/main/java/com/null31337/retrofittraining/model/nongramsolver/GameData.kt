package com.null31337.retrofittraining.model.nongramsolver

class GameData(private val n: Int, private val m: Int) {
    private val rows: MutableList<List<Int>> = MutableList(n) { MutableList(0) { 0 } }
    private val lines: MutableList<List<Int>> = MutableList(n) { MutableList(0) { 0 } }
    private val BoardLines = BoardTwoTypes(n, m)
    private val BoardRows = BoardTwoTypes(m, n)
    private val allCombinationLines = HashMap<List<Int>, MutableList<Long>>()
    private val allCombinationRows = HashMap<List<Int>, MutableList<Long>>()
    private val INF = Long.MAX_VALUE

    internal fun addData(x: Int, list: List<Int>, isRows: Boolean) {
        list.filter { it != 0 }
        if (isRows) {
            rows[x] = list
            if (!allCombinationRows.containsKey(list))
                generate(list, n, true)
        } else {
            lines[x] = list
            if (!allCombinationLines.containsKey(list))
                generate(list, m, false)
        }
    }

    private fun generate(
        list: List<Int>,
        size: Int,
        isRows: Boolean,
        position: Int = 0,
        current: Int = 0,
        posInCurrent: Int = 0,
        currentAns: Long = 0
    ) {
        if (list.isEmpty()) {
            allCombinationLines[list] = mutableListOf(0L)
            allCombinationRows[list] = mutableListOf(0L)
            return
        }
        if (position == size) {
            when {
                current != list.size -> return
                isRows -> {
                    allCombinationRows[list]?.add(currentAns) ?: run {
                        allCombinationRows[list] = mutableListOf(currentAns)
                    }
                }
                else -> {
                    allCombinationLines[list]?.add(currentAns) ?: run {
                        allCombinationLines[list] = mutableListOf(currentAns)
                    }
                }
            }
        }
        if (current == list.size) {
            generate(list, size, isRows, position, current, 0, currentAns.shl(1))
        }
        if (posInCurrent != 0) {
            if (list[current] == posInCurrent)
                generate(list, size, isRows, position, current + 1, 0, currentAns.shl(1))
            else
                generate(
                    list,
                    size,
                    isRows,
                    position,
                    current,
                    posInCurrent + 1,
                    currentAns.shl(1) + 1
                )
        } else {
            generate(list, size, isRows, position, current, 1, currentAns.shl(1) + 1)
            generate(list, size, isRows, position, current, 0, currentAns.shl(1))
        }
    }

    internal fun addStringData(x: Int, string: String, isRows: Boolean) =
        addData(x, string.split(", | ").map { Integer.parseInt(it) }, isRows)

    internal fun isEnd() = BoardLines.isEnd() || BoardRows.isEnd()
}
