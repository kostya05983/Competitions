package leetCode.hard

class ConstructProductMatrix {
    fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val resultGrid = Array(grid.size) { IntArray(grid[0].size) }

        var prefixProduct = 1L
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                resultGrid[i][j] = prefixProduct.rem(12345).toInt()
                prefixProduct = (prefixProduct * grid[i][j]).rem(12345)
            }
        }

        var suffixProduct = 1L
        for (i in grid.size - 1 downTo 0) {
            for (j in grid[0].size - 1 downTo 0) {
                resultGrid[i][j] = (resultGrid[i][j] * suffixProduct).rem(12345).toInt()
                suffixProduct = (suffixProduct * grid[i][j]).rem(12345)
            }
        }

        return resultGrid
    }
}

fun main() {
    val solution = ConstructProductMatrix()
    println(solution.constructProductMatrix(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))).map { it.toList() })
    println(
        solution.constructProductMatrix(arrayOf(intArrayOf(12345), intArrayOf(2), intArrayOf(1))).map { it.toList() })
    println(
        solution.constructProductMatrix(arrayOf(intArrayOf(123456), intArrayOf(2), intArrayOf(1))).map { it.toList() })
}