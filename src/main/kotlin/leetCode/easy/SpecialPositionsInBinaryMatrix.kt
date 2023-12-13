package leetCode.easy

class SpecialPositionsInBinaryMatrix {
    fun numSpecial(mat: Array<IntArray>): Int {
        var count = 0
        for (i in mat.indices) {
            for (j in 0 until mat[i].size) {
                if (mat[i][j] == 1) {
                    val left = recursive(i, j - 1, Direction.LEFT, mat)
                    val right = recursive(i, j + 1, Direction.RIGHT, mat)
                    val top = recursive(i - 1, j, Direction.TOP, mat)
                    val down = recursive(i + 1, j, Direction.DOWN, mat)
                    val result = left and right and top and down

                    if (result) count++
                }
            }
        }
        return count
    }

    enum class Direction {
        LEFT,
        RIGHT,
        TOP,
        DOWN
    }

    private fun recursive(i: Int, j: Int, direction: Direction, mat: Array<IntArray>): Boolean {
        if (i >= mat.size || i < 0) return true
        if (j >= mat[0].size || j < 0) return true

        if (mat[i][j] == 1) return false

        return when (direction) {
            Direction.LEFT -> recursive(i, j - 1, direction, mat)
            Direction.RIGHT -> recursive(i, j + 1, direction, mat)
            Direction.TOP -> recursive(i - 1, j, direction, mat)
            Direction.DOWN -> recursive(i + 1, j, direction, mat)
        }
    }
}

fun main(args: Array<String>) {
    val solution = SpecialPositionsInBinaryMatrix()
    println(solution.numSpecial(arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 0, 1), intArrayOf(1, 0, 0))))
    println(solution.numSpecial(arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))))
}