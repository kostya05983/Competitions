package leetCode.medium

class ContainerWithWater {
    fun maxArea(height: IntArray): Int {
        var result = 0
        var left = 0
        var right = height.size - 1

        while (left != right) {
            val leftHeight = height[left]
            val rightHeight = height[right]
            val distance = (right - left)

            result = maxOf(result, minOf(leftHeight, rightHeight) * distance)

            if (leftHeight < rightHeight) {
                left++
            } else {
                right--
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(ContainerWithWater().maxArea(intArrayOf(1,1)))
}