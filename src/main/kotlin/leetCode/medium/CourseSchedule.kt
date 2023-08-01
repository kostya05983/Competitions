package leetCode.medium

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class CourseSchedule {

    private fun isCycle(
        node: Int,
        adj: List<List<Int>>,
        visit: BooleanArray,
        inStack: BooleanArray
    ): Boolean {
        if (inStack[node]) return true

        if (visit[node]) return false

        visit[node] = true
        inStack[node] = true
        for (neighbour in adj[node]) {
            if (isCycle(neighbour, adj, visit, inStack)) {
                return true
            }
        }

        inStack[node] = false

        return false
    }


    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = mutableListOf<MutableList<Int>>()
        for (i in 0 until numCourses) {
            adj.add(mutableListOf())
        }

        for ((a, b) in prerequisites) {
            adj.get(b).add(a)
        }

        val visit = BooleanArray(numCourses)
        val inStack = BooleanArray(numCourses)
        for (i in 0 until numCourses) {
            if (isCycle(i, adj, visit, inStack)) {
                return false
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    val solution = CourseSchedule()
    val example1 = solution.canFinish(2, arrayOf(intArrayOf(1, 0)))
    assertTrue(example1)

    val example2 = solution.canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)))
    assertFalse(example2)

    val example3 = solution.canFinish(
        3,
        arrayOf(intArrayOf(1, 0), intArrayOf(0, 2), intArrayOf(2, 1))
    )
    assertFalse(example3)

    val example4 = solution.canFinish(
        3, arrayOf(
            intArrayOf(1, 0), intArrayOf(0, 2), intArrayOf(2, 3)
        )
    )
    assertTrue(example4)

    val example5 = solution.canFinish(
        3, arrayOf(intArrayOf(1, 0))
    )
    assertTrue(example5)

    val example6 = solution.canFinish(
        3, arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(0, 2)
        )
    )
    assertFalse(example6)

    val example7 = solution.canFinish(
        3, arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 2),
            intArrayOf(0, 1)
        )
    )
    assertFalse(example7)
}