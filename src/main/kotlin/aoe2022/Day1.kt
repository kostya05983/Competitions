package aoe2022

import java.io.File
import java.util.*
import kotlin.math.max

class Day1 {

    fun solve(): Int {
        val input = File("/home/kostya05983/Projects/Competitions/src/main/resources/input.txt").readLines()

        var sum = 0

        var currentSum = 0
        for (i in input.indices) {
            val number = input[i].toIntOrNull()
            if (number == null) {
                sum = max(sum, currentSum)
                currentSum = 0
            } else {
                currentSum += number
            }
        }

        return sum
    }

    fun solve2(): Int {
        val input = File("/home/kostya05983/Projects/Competitions/src/main/resources/input.txt").readLines()

        val priorityQueueHeap = PriorityQueue(Collections.reverseOrder<Int>())
        var currentSum = 0
        for (i in input.indices) {
            val number = input[i].toIntOrNull()
            if (number == null) {
                priorityQueueHeap.add(currentSum)
                currentSum = 0
            } else {
                currentSum += number
            }
        }

        return priorityQueueHeap.poll()+priorityQueueHeap.poll()+priorityQueueHeap.poll()
    }
}

fun main(args: Array<String>) {
    println(Day1().solve())
}