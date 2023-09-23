package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder

class RemoveAllAdjacentDuplicates {
    fun removeDuplicates(s: String): String {
        val sb = StringBuilder()

        for (ch in s) {
            if (sb.getOrNull(sb.length - 1) == ch) {
                sb.deleteCharAt(sb.length - 1)
                continue
            }
            sb.append(ch)
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = RemoveAllAdjacentDuplicates()
    val example1 = solution.removeDuplicates("abbaca")
    assertEquals("ca", example1)

    val example2 = solution.removeDuplicates("azxxzy")
    assertEquals("ay", example2)
}