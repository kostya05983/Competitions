package leetCode.easy

class HeightChecker {
    fun heightChecker(heights: IntArray): Int {
        val sorted = heights.sorted()
        var counter = 0
        for (i in heights.indices) {
            if (heights[i] != sorted[i]) {
                counter++
            }
        }
        return counter
    }
}

fun main(args: Array<String>) {
    println(HeightChecker().heightChecker(intArrayOf(1,1,4,2,1,3)))
}