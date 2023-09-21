package leetCode.easy

import org.junit.jupiter.api.Assertions.*

class UniqueNumberOfOccurrances {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val frequencyMap = HashMap<Int, Int>()

        for (i in arr.indices) {
            val oldFrequency = frequencyMap.getOrDefault(arr[i], 0)
            val newFrequency = oldFrequency + 1

            frequencyMap[arr[i]] = newFrequency
        }

        val uniqueSet = hashSetOf<Int>()
        for (entry in frequencyMap) {
            if (uniqueSet.contains(entry.value)) return false
            uniqueSet.add(entry.value)
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

    val example4 = solution.uniqueOccurrences(
        intArrayOf(
            26,
            2,
            16,
            16,
            5,
            5,
            26,
            2,
            5,
            20,
            20,
            5,
            2,
            20,
            2,
            2,
            20,
            2,
            16,
            20,
            16,
            17,
            16,
            2,
            16,
            20,
            26,
            16
        )
    )
    assertFalse(example4)

    val example5 = solution.uniqueOccurrences(intArrayOf(-1, -1, -1, -3, -1, -1))
    assertTrue(example5)
}