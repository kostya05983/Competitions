package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CountTheNumberOfVowelStringsInRange {
    fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
        var count = 0
        for (i in left..right) {
            val word = words[i]
            val first = word.first()
            val last = word.last()
            if (isVowel(first) && isVowel(last)) {
                count++
            }
        }

        return count
    }

    private fun isVowel(ch: Char): Boolean {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
    }
}

fun main(args: Array<String>) {
    val solution = CountTheNumberOfVowelStringsInRange()
    val example1 = solution.vowelStrings(arrayOf("are", "amy", "u"), 0, 2)
    assertEquals(2, example1)

    val example2 = solution.vowelStrings(arrayOf("hey", "aeo", "mu", "ooo", "artro"), 1, 4)
    assertEquals(3, example2)
}