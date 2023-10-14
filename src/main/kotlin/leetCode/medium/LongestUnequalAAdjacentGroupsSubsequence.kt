package leetCode.medium

import java.util.LinkedList
import java.util.Stack
import kotlin.system.measureTimeMillis

class LongestUnequalAAdjacentGroupsSubsequence {
    private val memory = mutableMapOf<Triple<Int, Int, Int>, List<Int>>()

    fun getWordsInLongestSubsequence(n: Int, words: Array<String>, groups: IntArray): List<String> {
        val dp = IntArray(n) { 0 }
        dp[0] = 1
        val parent = IntArray(n)

        for (i in 1 until n) {
            dp[i] = 1
            parent[i] = i
            for (j in i - 1 downTo 0) {
                if (groups[j] != groups[i] && words[i].length == words[j].length && hammingDistance(
                        words[i],
                        words[j]
                    ) == 1
                ) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1
                        parent[i] = j
                    }
                }
            }
        }

        var max = 0
        var maxIndex = 0
        for (i in dp.indices) {
            if (dp[i] > max) {
                max = dp[i]
                maxIndex = i
            }
        }

        val result = LinkedList<String>()
        var i = 1
        result.addFirst(words[maxIndex])
        while (i < max) {
            val j = parent[maxIndex]
            maxIndex = j
            result.addFirst(words[j])
            i++
        }

        return result
    }

    private fun hammingDistance(previous: String, current: String): Int {
        var count = 0
        for (i in previous.indices) {
            if (previous[i] != current[i]) count++
            if (count > 1) break
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = LongestUnequalAAdjacentGroupsSubsequence()
    println(solution.getWordsInLongestSubsequence(3, arrayOf("bab", "dab", "cab"), intArrayOf(1, 2, 2)))

    println(solution.getWordsInLongestSubsequence(3, arrayOf("e", "a", "b"), intArrayOf(0, 0, 1)))
    println(solution.getWordsInLongestSubsequence(4, arrayOf("a", "b", "c", "d"), intArrayOf(1, 0, 1, 1)))
    println(solution.getWordsInLongestSubsequence(1, arrayOf("a"), intArrayOf(0)))

    val result = measureTimeMillis {
        solution.getWordsInLongestSubsequence(
            20, arrayOf(
                "a", "b", "c", "d", "ttt", "sd", "ee", "ty", "hg", "erer",
                "ar", "br", "cr", "dr", "tttr", "sdr", "eer", "tyr", "hgr", "erert"
            ),
            intArrayOf(
                1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
            )
        )
    }
    println(result)

    println(solution.getWordsInLongestSubsequence(2, arrayOf("dbcdd", "baba"), intArrayOf(2, 1)))

    println(solution.getWordsInLongestSubsequence(4, arrayOf("dcaacc", "da", "ddcbd", "dd"), intArrayOf(2, 3, 1, 4)))
    println(
        solution.getWordsInLongestSubsequence(
            5,
            arrayOf("ba", "ee", "ed", "ddddd", "ce"),
            intArrayOf(4, 4, 4, 5, 5)
        )
    )

    println(
        solution.getWordsInLongestSubsequence(
            14,
            arrayOf("dba", "db", "cc", "aa", "ac", "da", "bc", "dda", "bb", "abb", "cd", "cad", "bdd", "ca"),
            intArrayOf(2, 7, 14, 4, 9, 9, 5, 9, 11, 12, 7, 8, 8, 3)
        )
    )
}