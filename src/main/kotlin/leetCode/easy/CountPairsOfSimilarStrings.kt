package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CountPairsOfSimilarStrings {
    fun similarPairs(words: Array<String>): Int {
        val sets = words.map{ it.toSet() }

        var result = 0
        for(i in sets.indices) {
            for(j in i + 1 until sets.size) {
                if (sets[i] == sets[j]) result++
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = CountPairsOfSimilarStrings()
    val example1 = solution.similarPairs(arrayOf("aba", "aabb", "abcd", "bac", "aabc"))
    assertEquals(2, example1)

    val example2 = solution.similarPairs(arrayOf("aabb", "ab", "ba"))
    assertEquals(3, example2)

    val example3 = solution.similarPairs(arrayOf("nba", "cba", "dba"))
    assertEquals(0, example3)
}