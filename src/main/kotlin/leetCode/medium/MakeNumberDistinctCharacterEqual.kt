package leetCode.medium

import org.junit.jupiter.api.Assertions.*
import kotlin.math.abs

class MakeNumberDistinctCharacterEqual {

    fun isItPossible(word1: String, word2: String): Boolean {
        val word1Frequencies = getFrequencies(word1)
        val word2Frequencies = getFrequencies(word2)

        val diff = abs(word1Frequencies.size - word2Frequencies.size)
        if (diff > 2) return false


        var notExistInWord1 = 0
        if (diff == 0) {
            for (frequency in word2Frequencies) {
                val value = word1Frequencies[frequency.key]
                if (value == null) notExistInWord1 = maxOf(notExistInWord1, frequency.value)
            }
        }

        for (entry in word1Frequencies) {
            val lessValue = word2Frequencies[entry.key]
            if (lessValue != null && diff != 0) continue

            if (diff == 0 && entry.value == lessValue) return true

            if (diff == 0 && notExistInWord1 == 0) return false

            if (diff == 0 && notExistInWord1 == 1) {
                return true
            }

            if (diff == 0 && entry.value > 1 && notExistInWord1 > 1) {
                return true
            }

            if (diff == 1 && entry.value >= 2) {
                return true
            }
            if (diff == 2 && entry.value == 1) {
                return true
            }
        }

        return false
    }

    private fun getFrequencies(word: String): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()
        for (ch in word) {
            result[ch] = result.getOrDefault(ch, 0) + 1
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MakeNumberDistinctCharacterEqual()
//
    assertFalse(solution.isItPossible("ac", "b"))
    assertTrue(solution.isItPossible("abcc", "aab"))
    assertTrue(solution.isItPossible("abcde", "fghij"))
    assertTrue(solution.isItPossible("abc", "a"))
    assertFalse(solution.isItPossible("ab", "abcc"))
    assertFalse(solution.isItPossible("a", "bb"))
    assertTrue(solution.isItPossible("aa", "bbb"))
    assertTrue(solution.isItPossible("abc", "abc"))
    assertTrue(solution.isItPossible("aa", "bb"))
    assertTrue(solution.isItPossible("aacc", "bbcc"))
    assertTrue(solution.isItPossible("aaccdd", "bbffee"))
}