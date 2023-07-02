package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class OddStringDifference {
    fun oddString(words: Array<String>): String {
        val firstDifference = mutableListOf<Int>()
        val firstWord = words[0]
        for (i in 1 until firstWord.length) {
            val difference = firstWord[i] - firstWord[i - 1]
            firstDifference.add(difference)
        }

        for (j in 1 until words.size) {
            val word = words[j]
            for (i in 1 until word.length) {
                val difference = word[i] - word[i - 1]
                if (difference != firstDifference[i - 1]) {
                    if (j == 1) {
                        val nextWord = words[j + 1]
                        val nextDifference = nextWord[i] - nextWord[i - 1]
                        if (difference == nextDifference) return firstWord
                    }
                    return word
                }
            }
        }

        throw RuntimeException("Illegal state")
    }
}

fun main(args: Array<String>) {
    val solution = OddStringDifference()
    val example1 = solution.oddString(arrayOf("adc", "wzy", "abc"))
    assertEquals("abc", example1)

    val example2 = solution.oddString(arrayOf("aaa", "bob", "ccc", "ddd"))
    assertEquals("bob", example2)
}