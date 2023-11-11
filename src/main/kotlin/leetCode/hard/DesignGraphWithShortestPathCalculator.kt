package leetCode.hard

import java.util.*
import kotlin.math.min


class DesignGraphWithShortestPathCalculator(n: Int, edges: Array<IntArray>) {
    private val adjMatrix: Array<IntArray> = Array(n) { IntArray(n) { 1e9.toInt() } }

    init {
        for (e: IntArray in edges) {
            adjMatrix[e[0]][e[1]] = e[2]
        }
        for (i in 0 until n) {
            adjMatrix[i][i] = 0
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    adjMatrix[j][k] = min(
                        adjMatrix[j][k],
                        adjMatrix[j][i] +
                                adjMatrix[i][k]
                    )
                }
            }
        }
    }

    fun addEdge(edge: IntArray) {
        val n = adjMatrix.size
        for (i in 0 until n) {
            for (j in 0 until n) {
                adjMatrix[i][j] = min(
                    adjMatrix[i][j],
                    adjMatrix[i][edge[0]] +
                            adjMatrix[edge[1]][j] +
                            edge[2]
                )
            }
        }
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        return if (adjMatrix[node1][node2] == 1e9.toInt()) -1 else adjMatrix[node1][node2]
    }
}