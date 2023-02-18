package leetCode.medium

class SubrectangleQueries(private val rectangle: Array<IntArray>) {

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (i in row1..row2) {
            for (j in col1..col2) {
                rectangle[i][j] = newValue
            }
        }
    }

    fun getValue(row: Int, col: Int): Int {
        return rectangle[row][col]
    }
}

fun main(args: Array<String>) {
    val solution =
        SubrectangleQueries(arrayOf(intArrayOf(1, 2, 1), intArrayOf(4, 3, 4), intArrayOf(3, 2, 1), intArrayOf(1, 1, 1)))
    val test1 = solution.getValue(0, 2)
    require(test1 == 1)

    solution.updateSubrectangle(0, 0, 3, 2, 5)
    val test2 = solution.getValue(0, 2)
    require(test2 == 5)
    val test3 = solution.getValue(3, 1)
    require(test3 == 5)

    solution.updateSubrectangle(3, 0, 3, 2, 10)
    val test4 = solution.getValue(3, 1)
    require(test4 == 10)
    val test5 = solution.getValue(0, 1)
    require(test5 == 5)
}