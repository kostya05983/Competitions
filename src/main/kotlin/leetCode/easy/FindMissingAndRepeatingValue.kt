package leetCode.easy

class FindMissingAndRepeatingValue {

    fun find(grid: Array<IntArray>): IntArray {
        val booleanArray = BooleanArray(grid.size*grid.size)

        for(row in grid) {
            for(col in row) {
                booleanArray[col-1] = !booleanArray[col]
            }
        }

        val result = mutableListOf<Int>()
        for(i in 0 until booleanArray.size) {
            val b = booleanArray[i]
            if (!b) result.add(i+1)
        }

        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution = FindMissingAndRepeatingValue()

    println(solution.find(arrayOf(intArrayOf(1,3), intArrayOf(2,2))).map { it })
}