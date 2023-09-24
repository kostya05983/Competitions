package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class ChampagneTower {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val rows = mutableListOf(doubleArrayOf(poured.toDouble()))

        for (i in 1..query_row) {
            val row = DoubleArray(i + 1)

            for (j in row.indices) {
                when (j) {
                    0 -> {
                        row[j] = getPreviousChampagne(rows, i - 1, j)
                    }

                    row.size - 1 -> {
                        row[j] = getPreviousChampagne(rows, i - 1, j - 1)
                    }

                    else -> {
                        val leftCup = getPreviousChampagne(rows, i - 1, j - 1)
                        val rightCup = getPreviousChampagne(rows, i - 1, j)

                        row[j] = leftCup + rightCup
                    }
                }
            }
            rows.add(row)
        }

        val result = rows[query_row][query_glass]
        return if (result > 1.0) {
            1.0
        } else {
            result
        }
    }

    private fun getPreviousChampagne(rows: List<DoubleArray>, row: Int, column: Int): Double {
        return (rows[row].getOrNull(column)?.takeIf { it >= 1.0 }?.let { it - 1 }?.takeIf { it >= 0.0 } ?: 0.0) / 2.0
    }
}

fun main(args: Array<String>) {
    val solution = ChampagneTower()
    val example1 = solution.champagneTower(1, 1, 1)
    assertEquals(0.0000, example1)

    val example2 = solution.champagneTower(2, 1, 1)
    assertEquals(0.5000, example2)

    val example3 = solution.champagneTower(100000009, 33, 17)
    assertEquals(1.0000, example3)
}