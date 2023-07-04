package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class StringMatchingInAnArray {
    fun stringMatching(words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        words.sortBy { it.length }

        for (i in words.indices) {
            val leftWord = words[i]
            for (j in i + 1 until words.size) {
                if (words[j].length != leftWord.length && words[j].contains(leftWord)) {
                    result.add(words[i])
                    break
                }
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = StringMatchingInAnArray()
    val example1 = solution.stringMatching(arrayOf("mass", "as", "hero", "superhero"))
    assertEquals(listOf("as", "hero"), example1)

    val example2 = solution.stringMatching(arrayOf("leetcode", "et", "code"))
    assertEquals(listOf("et", "code"), example2)

    val example3 = solution.stringMatching(arrayOf("blue", "green", "bu"))
    assertEquals(emptyList<String>(), example3)
}