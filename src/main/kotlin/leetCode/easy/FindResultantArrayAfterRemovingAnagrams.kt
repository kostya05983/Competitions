package leetCode.easy

import java.util.LinkedList


class FindResultantArrayAfterRemovingAnagrams {
    fun removeAnagrams(words: Array<String>): List<String> {
        val result = LinkedList(words.toList())

        var i = 1
        while (i < result.size) {
            val left = result[i - 1]
            val right = result[i]

            if (isAnagram(left, right)) {
                result.removeAt(i)
                continue
            }
            i++
        }

        return result
    }

    private fun isAnagram(left: String, right: String): Boolean {
        val leftChars = left.toCharArray()
        val rightChars = right.toCharArray()
        leftChars.sort()
        rightChars.sort()

        return leftChars.contentEquals(rightChars)
    }
}

fun main(args: Array<String>) {
    val solution = FindResultantArrayAfterRemovingAnagrams()
    solution.removeAnagrams(arrayOf("abba", "baba", "bbaa", "cd", "cd"))
}