package leetCode.medium

class RestoreArrayFromAdjacentPairs {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val graph = HashMap<Int, MutableList<Int>>()

        for (pair in adjacentPairs) {
            val fromTo = graph.getOrDefault(pair[0], mutableListOf())
            fromTo.add(pair[1])
            graph[pair[0]] = fromTo

            val toFrom = graph.getOrDefault(pair[1], mutableListOf())
            toFrom.add(pair[0])
            graph[pair[1]] = toFrom
        }

        val root = graph.keys.first {
            graph[it]!!.size == 1
        }


        val result = IntArray(graph.size)
        dfs(root, Int.MAX_VALUE, result, 0, graph)

        return result
    }

    private fun dfs(node: Int, prev: Int, result: IntArray, i: Int, graph: Map<Int, List<Int>>) {
        result[i] = node

        for (neighbour in graph[node]!!) {
            if (neighbour != prev) {
                dfs(neighbour, node, result, i + 1, graph)
            }
        }
    }
}

fun main(args: Array<String>) {
    val solution = RestoreArrayFromAdjacentPairs()
    println(solution.restoreArray(arrayOf(intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(3, 2))))
}