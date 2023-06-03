package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class ReplaceTheSubstringForBalancedString {
    fun balancedString(s: String): Int {
        val map = mutableMapOf('Q' to 0, 'W' to 0, 'E' to 0, 'R' to 0)
        val goal = s.length / 4

        for (ch in s) {
            map[ch] = map[ch]!! + 1
        }

        if (map.all { it.value == goal }) return 0

        var left = 0
        var minLength = s.length

        for (i in s.indices) {
            val ch = s[i]

            map[ch] = map[ch]!! - 1

            while (left < s.length && map.all { it.value <= goal }) {
                val popped = s[left]
                minLength = minOf(minLength, i - left + 1)
                map[popped] = map[popped]!! + 1

                left++
            }
        }

        return minLength
    }
}

fun main(args: Array<String>) {
    val solution = ReplaceTheSubstringForBalancedString()
    val example1 = solution.balancedString("QWER")
    require(example1 == 0)

    val example2 = solution.balancedString("QQWE")
    assertEquals(1, example2)

    val example3 = solution.balancedString("QQQW")
    assertEquals(2, example3)

    val example4 = solution.balancedString("WQQWEWRREWQERWWW")
    assertEquals(3, example4)

    val example5 = solution.balancedString("WQQWEWEEEWQERWWW")
    assertEquals(5, example5)

    val example6 = solution.balancedString("WQQQEWEREWQERWWW")
    assertEquals(2, example6)

    val example7 = solution.balancedString("WQWRQQQW")
    assertEquals(3, example7)
}