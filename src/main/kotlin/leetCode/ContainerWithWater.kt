package leetCode

class ContainerWithWater {
    fun maxArea(height: IntArray): Int {
        var result = 0
        for (i in height.indices) {
            for (j in i until height.size) {
                val minHeight = minOf(height[i], height[j])
                result = maxOf(result, minHeight * (j - i))
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(ContainerWithWater().maxArea(intArrayOf(1, 1)))
}