package leetCode.easy

class ValidBoomerang {
    fun isBoomerang(points: Array<IntArray>): Boolean {
        for (i in 0 until points.size - 2) {
            val (x, y) = points[i]
            val (x2, y2) = points[i + 1]
            val (x3, y3) = points[i + 2]

            if (x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2) == 0) return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution = ValidBoomerang()

    val test1 = solution.isBoomerang(arrayOf(intArrayOf(1, 1), intArrayOf(2, 3), intArrayOf(3, 2)))
    require(test1)

    val test2 = solution.isBoomerang(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3)))
    require(!test2)
}