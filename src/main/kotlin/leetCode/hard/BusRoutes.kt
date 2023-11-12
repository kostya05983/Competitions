package leetCode.hard

import java.util.LinkedList

class BusRoutes {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) return 0

        val graph = HashMap<Int, MutableList<Int>>()

        for (i in routes.indices) {
            for (stop in routes[i]) {
                val route = graph.getOrDefault(stop, mutableListOf())
                route.add(i)
                graph[stop] = route
            }
        }

        val queue = LinkedList<Int>()

        val visited = HashSet<Int>()
        for (route in graph[source]!!) {
            queue.add(route)
            visited.add(route)
        }

        var result = 1
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val route = queue.remove()

                for (stop in routes[route]) {
                    if (stop == target) {
                        return result
                    }

                    for (nextRoute in graph[stop]!!) {
                        if (!visited.contains(nextRoute)) {
                            visited.add(nextRoute)
                            queue.add(nextRoute)
                        }
                    }
                }
            }
            result++
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val solution = BusRoutes()
    println(solution.numBusesToDestination(arrayOf(intArrayOf(1, 2, 7), intArrayOf(3, 6, 7)), 1, 6))
    println(
        solution.numBusesToDestination(
            arrayOf(
                intArrayOf(7, 12),
                intArrayOf(4, 5, 15),
                intArrayOf(6),
                intArrayOf(15, 19),
                intArrayOf(9, 12, 13)
            ), 15, 12
        )
    )


}