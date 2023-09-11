package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        var readSPointer = 0
        var readTPointer = 0

        while (readTPointer < t.length) {
            if (s[readSPointer] != t[readTPointer]) {
                readTPointer++
            } else {
                readSPointer++
                readTPointer++
            }
            if (readSPointer == s.length) return true
            if (readTPointer == t.length) return false
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = IsSubsequence()
    val example1 = solution.isSubsequence("abc", "ahbgdc")
    assertEquals(true, example1)

    val example2 = solution.isSubsequence("axc", "ahbgdc")
    assertEquals(false, example2)

    val example3 = solution.isSubsequence("aaaaaa", "bbaaaa")
    assertEquals(false, example3)
}