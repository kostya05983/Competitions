package leetCode.medium

import java.util.Stack

class BuildAnArrayWithStackOperations {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val result = Stack<String>()

        var targetPointer = 0
        for (i in 1..n) {
            if (target[targetPointer] == i) {
                result.add("Push")
                targetPointer++
            } else {
                result.add("Push")
                result.add("Pop")
            }
            if (targetPointer == target.size) break
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = BuildAnArrayWithStackOperations()
    println(solution.buildArray(intArrayOf(1, 3), 3))
    println(solution.buildArray(intArrayOf(1, 2, 3), 3))
    println(solution.buildArray(intArrayOf(1, 2), 4))
}