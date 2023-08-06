package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class LongestCommonSubstring {

    fun commonSubstring(s1: String, s2: String): Int {
        val lookupTable = Array(s1.length + 1) { IntArray(s2.length + 1) { 0 } }

        var maxLength = 0
        for (left in 1..s1.length) {
            for (right in 1..s2.length) {
                if (s1[left - 1] == s2[right - 1]) {
                    lookupTable[left][right] = 1 + lookupTable[left - 1][right - 1]
                    maxLength = maxOf(maxLength, lookupTable[left][right])
                }
            }
        }

        return maxLength
    }
}

fun main(args: Array<String>) {
    val solution = LongestCommonSubstring()
    val example1 = solution.commonSubstring("www.educative.io/explore", "educative.io/edpresso")
    assertEquals(14, example1)
}