package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.ArrayDeque

class TheTimeWhenTheNetworkBecomesIdle {

    data class NetworkNode(
        val patience: Int,
        val children: MutableList<NetworkNode>,
        var distance: Int,
        val index: Int
    )

    fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
        val networkNodes = Array(patience.size) {
            NetworkNode(
                patience[it],
                children = mutableListOf(),
                distance = -1,
                index = it
            )
        }

        for ((left, right) in edges) {
            networkNodes[left].children.add(networkNodes[right])
            networkNodes[right].children.add(networkNodes[left])
        }

        bfs(networkNodes)

        val earliestIdleSecond = networkNodes.asSequence().drop(1).map {
            calculateTimeToIdle(it)
        }.max()!!

        return earliestIdleSecond + 1
    }

    private fun calculateTimeToIdle(node: NetworkNode): Int {
        val roundTrip = node.distance * 2
        if (node.patience >= roundTrip) {
            return roundTrip
        }

        return roundTrip + ((roundTrip - 1) / node.patience) * node.patience
    }

    private fun bfs(network: Array<NetworkNode>) {
        val queue = ArrayDeque<NetworkNode>()
        queue.push(network[0])
        network[0].distance = 0

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            for (child in node.children) {
                if (child.distance == -1) {
                    child.distance = node.distance + 1
                    queue.add(child)
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val solution = TheTimeWhenTheNetworkBecomesIdle()
    val example1 = solution.networkBecomesIdle(
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2)
        ),
        intArrayOf(0, 2, 1)
    )
    assertEquals(8, example1)

    val example2 = solution.networkBecomesIdle(
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 2)
        ),
        intArrayOf(0, 10, 10)
    )
    assertEquals(3, example2)

    val example3 = solution.networkBecomesIdle(
        """[3,8],[4,13],[0,7],[0,4],[1,8],[14,1],[7,2],[13,10],[9,11],[12,14],[0,6],[2,12],[11,5],[6,9],[10,3]"""
            .replace("]", "").replace("[", "")
            .split(",")
            .chunked(2)
            .map {
                intArrayOf(it[0].toInt(), it[1].toInt())
            }.toTypedArray(),
        intArrayOf(0, 3, 2, 1, 5, 1, 5, 5, 3, 1, 2, 2, 2, 2, 1)
    )
    assertEquals(20, example3)
}