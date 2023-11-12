package leetCode.medium

import java.util.LinkedList
import java.util.PriorityQueue

class HighAccessEmployees {
    fun findHighAccessEmployees(access_times: List<List<String>>): List<String> {
        val grouped = HashMap<String, PriorityQueue<Int>>()

        for ((employee, time) in access_times) {
            val newValue = grouped.getOrDefault(employee, PriorityQueue())
            newValue.add(transformToInt(time))
            grouped[employee] = newValue
        }

        val result = mutableListOf<String>()
        for (entry in grouped) {
            val values = entry.value

            val queue = LinkedList<Int>()
            while (values.isNotEmpty()) {
                val polled = values.poll()
                while (queue.isNotEmpty() && polled - queue.first >= 100) {
                    queue.pollFirst()
                }
                queue.add(polled)

                if (queue.size == 3) {
                    result.add(entry.key)
                    break
                }
            }
        }

        return result
    }

    private fun transformToInt(time: String): Int {
        return if (time[0] == '0') {
            time.substring(1, 4).toInt()
        } else {
            time.toInt()
        }
    }
}

fun main(args: Array<String>) {
    val solution = HighAccessEmployees()
    println(
        solution.findHighAccessEmployees(
            mutableListOf(
                listOf("a", "0621"),
                listOf("a", "0549"),
                listOf("b", "0457"),
                listOf("a", "0532"),

                listOf("b", "0540")
            )
        )
    )

    println(
        solution.findHighAccessEmployees(
            mutableListOf(
                listOf("a", "0549"),
                listOf("b", "0005"),
                listOf("a", "0332"),
                listOf("a", "0621"),
                listOf("b", "2344"),
                listOf("b", "2355")
            )
        )
    )

    println(
        solution.findHighAccessEmployees(
            mutableListOf(
                listOf("uixav", "0510"),
                listOf("zbggqxck", "0545"),
                listOf("hyxoa", "0619"),
                listOf("uixav", "0517"),
                listOf("zbggqxck", "0609"),
                listOf("zbggqxck", "0527"),
                listOf("zkjxcrd", "0545"),
                listOf("uixav", "0617"),
                listOf("uixav", "0530")
            )
        )
    )
}