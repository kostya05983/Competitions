package leetCode.medium

import java.util.*

class DailyTemperatures {


    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)

        val stack = Stack<Int>()

        for (i in temperatures.indices) {
            val temperature = temperatures[i]

            while (stack.isNotEmpty() && temperatures[stack.peek()] < temperature) {
                val index = stack.pop()
                result[index] = i - index
            }

            stack.add(i)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = DailyTemperatures()
    println(solution.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).toList())
    println(solution.dailyTemperatures(intArrayOf(30, 40, 50, 60)).toList())
    println(solution.dailyTemperatures(intArrayOf(30, 60, 90)).toList())
}