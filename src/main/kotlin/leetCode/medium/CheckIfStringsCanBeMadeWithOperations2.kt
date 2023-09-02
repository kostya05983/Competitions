package leetCode.medium

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class CheckIfStringsCanBeMadeWithOperations2 {
    fun checkStrings(s1: String, s2: String): Boolean {
        val frequenciesEven = mutableMapOf<Char, Int>()
        val frequenciesOdd = mutableMapOf<Char, Int>()

        for (i in s1.indices) {
            val ch = s1[i]
            if (i.rem(2) == 0) {
                frequenciesEven[ch] = frequenciesEven.getOrDefault(ch, 0) + 1
            } else {
                frequenciesOdd[ch] = frequenciesOdd.getOrDefault(ch, 0) + 1
            }
        }

        for (i in s2.indices) {
            val ch = s2[i]
            if (i.rem(2) == 0) {
                frequenciesEven[ch] = frequenciesEven.getOrDefault(ch, 0) - 1
            } else {
                frequenciesOdd[ch] = frequenciesOdd.getOrDefault(ch, 0) - 1
            }
        }

        for (entry in frequenciesEven) {
            if (entry.value < 0) return false
        }
        for (entry in frequenciesOdd) {
            if (entry.value < 0) return false
        }

        return true
    }
}

fun main(args: Array<String>) {
    val solution = CheckIfStringsCanBeMadeWithOperations2()
    val example1 = solution.checkStrings("abcdba", "cabdab")
    assertTrue(example1)

    val example2 = solution.checkStrings("abe", "bea")
    assertFalse(example2)

    val example3 = solution.checkStrings(
        "kvwdssgl",
        "wskxsdgv"
    )
    assertFalse(example3)
}