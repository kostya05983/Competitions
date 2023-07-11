package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CheckArrayFormationThroughConcatenation {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val pieceMap = mutableMapOf<Int, IntArray>()

        for (piece in pieces) {
            pieceMap[piece[0]] = piece
        }

        var i = 0
        while (i < arr.size) {
            val element = arr[i]
            val value = pieceMap[element] ?: return false
            i++
            for (j in 1 until value.size) {
                val element = arr[i]
                if (element != value[j]) return false
                i++
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    val solution = CheckArrayFormationThroughConcatenation()
    val example1 = solution.canFormArray(intArrayOf(15, 88), arrayOf(intArrayOf(88), intArrayOf(15)))
    assertEquals(true, example1)

    val example2 = solution.canFormArray(intArrayOf(49, 18, 16), arrayOf(intArrayOf(16, 18, 49)))
    assertEquals(false, example2)

    val example3 =
        solution.canFormArray(intArrayOf(91, 4, 64, 78), arrayOf(intArrayOf(78), intArrayOf(4, 64), intArrayOf(91)))
    assertEquals(true, example3)
}