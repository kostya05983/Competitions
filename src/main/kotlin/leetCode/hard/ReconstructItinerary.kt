package leetCode.hard

import java.util.LinkedList

class ReconstructItinerary {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val sorted = tickets.sortedBy { it[1] }
        val ticketDictionary = mutableMapOf<String, MutableList<String>>()

        for (ticket in sorted) {
            val key = ticket[0]
            val value = ticket[1]
            ticketDictionary[key] = ticketDictionary.getOrDefault(key, mutableListOf()).also { it.add(value) }
        }

        val result = LinkedList<String>().apply {
            add("JFK")
        }

        fun dfs(key: String): Boolean {
            if (result.size == tickets.size + 1) {
                return true
            }
            val paths = ticketDictionary[key] ?: return false

            val temp = LinkedList(paths)
            for (i in 0 until temp.size) {
                val v = paths.removeAt(i)
                result.add(v)

                if (dfs(v)) return true

                paths.add(i, v)
                result.removeLast()
            }

            return false
        }

        dfs("JFK")

        return result
    }
}

fun main(args: Array<String>) {
    val solution = ReconstructItinerary()
    val example1 = solution.findItinerary(
        listOf(
            listOf("MUC", "LHR"),
            listOf("JFK", "MUC"),
            listOf("SFO", "SJC"),
            listOf("LHR", "SFO"),
        )
    )

    println(example1)

    val example2 = solution.findItinerary(
        listOf(
            listOf("JFK", "SFO"),
            listOf("JFK", "ATL"),
            listOf("SFO", "ATL"),
            listOf("ATL", "JFK"),
            listOf("ATL", "SFO")
        )
    )
    println(example2)

    val example3 = solution.findItinerary(
        listOf(
            listOf("JFK", "KUL"),
            listOf("JFK", "NRT"),
            listOf("NRT", "JFK")
        )
    )
    println(example3)
}