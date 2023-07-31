package leetCode.medium

import org.junit.jupiter.api.Assertions.assertArrayEquals

class WhereWillTheBallFall {
    fun findBall(grid: Array<IntArray>): IntArray {
        val n = grid[0].size

        val positions = IntArray(n) { it }

        for (i in grid.indices) {
            for (j in positions.indices) {
                val position = positions[j]
                if (positions[j] == -1) continue

                //left wall
                if (position == 0 && grid[i][position] == -1) {
                    positions[j] = -1
                    continue
                }

                //right wall
                if (position == n - 1 && grid[i][n - 1] == 1) {
                    positions[j] = -1
                    continue
                }

                if (position != n - 1 && grid[i][position] == 1 && grid[i][position + 1] == -1) {
                    positions[j] = -1
                    continue
                }

                if (position != 0 && grid[i][position] == -1 && grid[i][position - 1] == 1) {
                    positions[j] = -1
                    continue
                }

                if (grid[i][position] == -1) {
                    positions[j] -= 1
                } else {
                    positions[j] += 1
                }
            }
        }

        return positions
    }
}

fun main(args: Array<String>) {
    val solution = WhereWillTheBallFall()
    val example1 = solution.findBall(
        arrayOf(
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(-1, -1, -1, 1, 1),
            intArrayOf(1, 1, 1, 1, -1),
            intArrayOf(-1, -1, -1, -1, -1)
        )
    )
    assertArrayEquals(intArrayOf(1, -1, -1, -1, -1), example1)

    val example2 = solution.findBall(
        arrayOf(
            intArrayOf(-1)
        )
    )
    assertArrayEquals(intArrayOf(-1), example2)

    val example3 = solution.findBall(
        arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1)
        )
    )
    assertArrayEquals(intArrayOf(0, 1, 2, 3, 4, -1), example3)

}