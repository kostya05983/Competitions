package leetCode.easy

class FindMissingAndRepeatingValue {

    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val booleanArray = BooleanArray(grid.size * grid.size)

        var a = 0
        for (row in grid) {
            for (col in row) {
                if (booleanArray[col - 1]) {
                    a = col
                    continue
                }

                booleanArray[col - 1] = !booleanArray[col - 1]
            }
        }

        val result = mutableListOf<Int>()
        for (i in booleanArray.indices) {
            val value = booleanArray[i]
            if (!value) return intArrayOf(a, i + 1)
        }

        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution = FindMissingAndRepeatingValue()

    println(solution.findMissingAndRepeatedValues(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2))).map { it })
}