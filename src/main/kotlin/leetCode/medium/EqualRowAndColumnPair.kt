package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals


class EqualRowAndColumnPair {
    fun equalPairs(grid: Array<IntArray>): Int {
        val frequencyMap = mutableMapOf<String, Int>()

        for (row in grid) {
            val joined = row.joinToString(" ")
            frequencyMap[joined] = frequencyMap.getOrDefault(joined, 0) + 1
        }

        val sb = StringBuilder()
        var count = 0
        for (i in 0 until grid[0].size) {
            for (j in 0 until grid.size) {
                sb.append(grid[j][i])
                if (j != grid.lastIndex)
                    sb.append(" ")
            }
            val amount = frequencyMap[sb.toString()]
            if (amount != null) count += amount
            sb.setLength(0)
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = EqualRowAndColumnPair()

    val example2 = solution.equalPairs(
        arrayOf(
            intArrayOf(3, 1, 2, 2),
            intArrayOf(1, 4, 4, 5),
            intArrayOf(2, 4, 2, 2),
            intArrayOf(2, 4, 2, 2)
        )
    )
    assertEquals(3, example2)

    val example3 = solution.equalPairs(
        arrayOf(
            intArrayOf(11, 1),
            intArrayOf(1, 11)
        )
    )
    assertEquals(2, example3)
}