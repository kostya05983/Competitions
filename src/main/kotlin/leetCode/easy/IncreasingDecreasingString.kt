package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class IncreasingDecreasingString {
    fun sortString(s: String): String {
        val frequencies = IntArray(26)

        for (ch in s) {
            val index = ch - 'a'
            frequencies[index]++
        }

        val sb = StringBuilder(s.length)

        while (sb.length != s.length) {
            for (i in frequencies.indices) {
                val frequency = frequencies[i]
                if (frequency <= 0) continue

                frequencies[i]--
                sb.append((i + FIRST_LETTER).toChar())
            }

            for (i in frequencies.lastIndex downTo 0) {
                val frequency = frequencies[i]
                if (frequency <= 0) continue

                frequencies[i]--
                sb.append((i + FIRST_LETTER).toChar())
            }
        }

        return sb.toString()
    }

    private companion object {
        const val FIRST_LETTER = 97
    }
}

fun main(args: Array<String>) {
    val solution = IncreasingDecreasingString()

    val example1 = solution.sortString("aaaabbbbcccc")
    assertEquals("abccbaabccba", example1)

    val example2 = solution.sortString("rat")
    assertEquals("art", example2)
}