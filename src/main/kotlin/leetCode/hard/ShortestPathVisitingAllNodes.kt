package leetCode.hard

import java.util.LinkedList

class ShortestPathVisitingAllNodes {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val finalState = (1.shl(graph.size)) - 1

        val queue = LinkedList<IntArray>()

        for (i in graph.indices) {
            queue.add(intArrayOf(i, 1.shl(i)))
        }

        val visitedMap = Array(graph.size) { IntArray(finalState + 1) }

        var shortestPath = 0

        while (queue.isNotEmpty()) {
            val size = queue.size
            shortestPath++
            for (i in 0 until size) {
                val head = queue.poll()
                val nodeId = head[0]
                val visitedNodeBitState = head[1]
                for (neighbour in graph[nodeId]) {
                    val newVisitedNodeBitState = visitedNodeBitState.or(1.shl(neighbour))

                    if (visitedMap[neighbour][newVisitedNodeBitState] == 1) continue
                    visitedMap[neighbour][newVisitedNodeBitState] = 1
                    if (newVisitedNodeBitState == finalState) return shortestPath
                    queue.add(intArrayOf(neighbour, newVisitedNodeBitState))
                }
            }
        }

        return -1
    }
}