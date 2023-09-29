package leetCode.hard

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.LinkedList

class CountValidPathsInTree {
    fun countPaths(n: Int, edges: Array<IntArray>): Long {
        val paths = Array<MutableList<Int>>(n + 1) { mutableListOf() }

        for ((from, to) in edges) {
            paths[from].add(to)
            paths[to].add(from)
        }

        val result = LongArray(1)
        recursivelySearch(1, 0, paths, result)
        return result[0]
    }

    data class Pair(
        var first: Int,
        var second: Int
    )

    private fun recursivelySearch(
        current: Int,
        parent: Int,
        paths: Array<MutableList<Int>>,
        array: LongArray
    ): Pair {
        val isPrime = isPrime(current)

        val pair = Pair(if (!isPrime) 1 else 0, if (isPrime) 1 else 0)

        for (path in paths[current]) {
            if (path == parent) continue

            val child = recursivelySearch(path, current, paths, array)

            array[0] += child.first * pair.second + child.second * pair.first.toLong()

            if (isPrime) {
                pair.second += child.first
            } else {
                pair.first += child.first
                pair.second += child.second
            }
        }

        return pair
    }

    private val primeMemory = mutableMapOf<Int, Boolean>()

    private fun isPrime(num: Int): Boolean {
        val memorized = primeMemory[num]
        if (memorized != null) return memorized

        if (num <= 1) return false

        if (num == 2 || num == 3) return true

        if (num % 2 == 0 || num % 3 == 0) return false

        var i = 5
        while (i <= kotlin.math.sqrt(num.toDouble())) {
            if (num % i == 0 || num % (i + 2) == 0) {
                primeMemory[num] = false
                return false
            }
            i += 6
        }

        primeMemory[num] = true
        return true
    }
}

fun main(args: Array<String>) {
    val solution = CountValidPathsInTree()
    val example1 =
        solution.countPaths(5, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(2, 5)))
    assertEquals(4, example1)

    val example2 = solution.countPaths(
        6,
        arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(3, 5), intArrayOf(3, 6))
    )
    assertEquals(6, example2)

    val example3 = solution.countPaths(4, arrayOf(intArrayOf(1, 2), intArrayOf(4, 1), intArrayOf(3, 4)))
    assertEquals(4, example3)

    val example4 =
        solution.countPaths(5, arrayOf(intArrayOf(1, 3), intArrayOf(4, 3), intArrayOf(2, 3), intArrayOf(5, 2)))
    assertEquals(3, example4)
}