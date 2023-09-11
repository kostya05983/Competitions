package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MaximumNumberOfVowelsInSubstringGivenLength {
    private val vowelDictionary = mutableSetOf('a', 'e', 'i', 'o', 'u')

    fun maxVowels(s: String, k: Int): Int {
        var max = 0
        var vowelCount = 0
        var i = 0

        while (i < s.length) {
            val ch = s[i]
            if (vowelDictionary.contains(ch)) vowelCount++

            if (i >= k - 1) {
                max = maxOf(max, vowelCount)
                if (vowelDictionary.contains(s[i - k + 1])) vowelCount--
            }
            i++

            if (max == k) return max
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = MaximumNumberOfVowelsInSubstringGivenLength()
    val example1 = solution.maxVowels("abciiidef", 3)
    assertEquals(3, example1)

    val example2 = solution.maxVowels("aeiou", 2)
    assertEquals(2, example2)

    val example3 = solution.maxVowels("leetcode", 3)
    assertEquals(2, example3)

    val example4 = solution.maxVowels("e", 1)
    assertEquals(1, example4)

    val example5 = solution.maxVowels("b", 1)
    assertEquals(0, example5)
}