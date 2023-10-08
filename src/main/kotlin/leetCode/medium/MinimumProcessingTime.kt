package leetCode.medium

import java.util.PriorityQueue

class MinimumProcessingTime {
    fun minProcessingTime(processorTime: List<Int>, tasks: List<Int>): Int {
        val sortedTasks = tasks.sortedDescending()

        val heap = PriorityQueue<Int>()
        for (time in processorTime) {
            for (i in 0 until 4) {
                heap.add(time)
            }
        }

        var maxTime = heap.peek()
        for (element in sortedTasks) {
            val polled = heap.poll()
            val newTime = polled + element
            maxTime = maxOf(maxTime, newTime)
        }

        return maxTime
    }
}

fun main(args: Array<String>) {
    val solution = MinimumProcessingTime()
    println(solution.minProcessingTime(listOf(10, 20), listOf(2, 3, 1, 2, 5, 8, 4, 3)))
}