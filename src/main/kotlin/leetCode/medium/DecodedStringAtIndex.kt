package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.TreeMap

class DecodedStringAtIndex {
    fun decodeAtIndex(s: String, k: Int): String {
        var n = 0L
        var i = 0

        while (n < k) {
            val ch = s[i]
            if (ch.isLetter()) {
                n += 1
            } else {
                n *= (ch -'0')
            }
            i++
        }

        i--
        var remainK = k.toLong()
        while (i > 0) {
            val ch = s[i]
            if (ch.isDigit()) {
                n /= ch - '0'
                remainK = remainK.rem(n)
            } else {
                if (remainK.rem(n) == 0L) {
                    break
                }
                n--
            }
            i--
        }

        return s[i].toString()
    }
}

fun main(args: Array<String>) {
    val solution = DecodedStringAtIndex()
    val example1 = solution.decodeAtIndex("leet2code3", 10)
    assertEquals("o", example1)

    val example2 = solution.decodeAtIndex("ha22", 5)
    assertEquals("h", example2)

    val example3 = solution.decodeAtIndex("a2345678999999999999999", 1)
    assertEquals("a", example3)

    val example4 = solution.decodeAtIndex("a", 1)
    assertEquals("a", example4)
//
//    //aabaabaab
    val example5 = solution.decodeAtIndex("a2b3c4d5e6f7g8h9", 3)
    assertEquals("b", example5)

    val example6 = solution.decodeAtIndex("vk6u5xhq9v", 554)
    assertEquals("k", example6)

    val example7 = solution.decodeAtIndex(
        "czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps",
        768077956
    )
    assertEquals("c", example7)
}