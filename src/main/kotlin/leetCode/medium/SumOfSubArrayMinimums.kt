package leetCode.medium

import java.util.Stack

class SumOfSubArrayMinimums {
    fun sumSubarrayMins(arr: IntArray): Int {
        val mod = 1000000007

        val stack = Stack<Int>()
        var sum = 0L

        for (i in 0..arr.size) {
            while (!stack.isEmpty() && (i == arr.size || arr[stack.peek()] >= arr[i])) {
                val mid = stack.pop()
                val left = if (stack.isEmpty()) -1 else stack.peek()
                val right = i

                val count = ((mid - left).toLong() * (right - mid)).rem(mod)

                sum += (count * arr[mid]).rem(mod)
                sum = sum.rem(mod)
            }
            stack.push(i)
        }

        return sum.toInt()
    }
}

fun main(args: Array<String>) {
    val solution = SumOfSubArrayMinimums()
    println(solution.sumSubarrayMins(intArrayOf(3, 1, 2, 4)))
    println(solution.sumSubarrayMins(intArrayOf(11, 81, 94, 43, 3)))
}