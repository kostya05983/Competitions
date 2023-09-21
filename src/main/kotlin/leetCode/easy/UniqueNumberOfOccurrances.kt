package leetCode.easy

import org.junit.jupiter.api.Assertions.*
import java.util.TreeMap

class UniqueNumberOfOccurrances {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val frequencyMap = TreeMap<Int, Int>()

        for (i in arr.indices) {
            frequencyMap[arr[i]] = frequencyMap.getOrDefault(arr[i], 0) + 1
        }

        var previous: Map.Entry<Int, Int>? = null
        for (entry in frequencyMap) {
            if (previous?.value == entry.value) return false
            previous = entry
        }

        return true
    }
}

fun main(args: Array<String>) {
    val solution = UniqueNumberOfOccurrances()
    val example1 = solution.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3))
    assertTrue(example1)

    val example2 = solution.uniqueOccurrences(intArrayOf(1, 2))
    assertFalse(example2)

    val example3 = solution.uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0))
    assertTrue(example3)
}