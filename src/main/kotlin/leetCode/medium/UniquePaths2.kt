package leetCode.medium

class UniquePaths2 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid[0][0] == 1) return 0

        obstacleGrid[0][0] = 1

        for (i in obstacleGrid.indices) {
            for (j in 0 until obstacleGrid[0].size) {
                if ((i != 0 || j != 0) && obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1
                    continue
                }
                if (i == 0 && j == 0) continue

                val left = obstacleGrid[i].getOrNull(j - 1)?.takeIf { it != -1 } ?: 0
                val right = obstacleGrid.getOrNull(i - 1)?.get(j)?.takeIf { it != -1 } ?: 0

                obstacleGrid[i][j] = left + right
            }
        }

        val last = obstacleGrid.last().last()

        return if (last == -1) 0 else last
    }
}

fun main(args: Array<String>) {
    val solution = UniquePaths2()
    println(
        solution.uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )

    println(
        solution.uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 0)
            )
        )
    )
    println(
        solution.uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1)
            )
        )
    )
    println(
        solution.uniquePathsWithObstacles(
            arrayOf(intArrayOf(1))
        )
    )
}