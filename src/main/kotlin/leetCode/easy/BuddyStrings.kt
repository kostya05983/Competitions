package leetCode.easy

import org.junit.jupiter.api.Assertions.*

class BuddyStrings {
    fun buddyStrings(s: String, goal: String): Boolean {
        var count = 0

        if (s.length != goal.length) return false

        val frequencies = mutableMapOf<Char, Int>()
        var isDuplicates = false

        val diffIndexes = IntArray(3) { -1 }
        for (i in s.indices) {
            if (count > 2) return false
            if (s[i] != goal[i]) {
                diffIndexes[count] = i
                count++
            }

            val newValue = frequencies.getOrDefault(s[i], 0) + 1
            frequencies[s[i]] = newValue
            if (newValue >= 2) isDuplicates = true
        }

        if (count == 1) return false

        if (diffIndexes[0] != -1) {
            val sCharArray = s.toCharArray()
            val temp = sCharArray[diffIndexes[0]]
            sCharArray[diffIndexes[0]] = sCharArray[diffIndexes[1]]
            sCharArray[diffIndexes[1]] = temp
            return String(sCharArray) == goal
        }

        return count == 0 && isDuplicates
    }
}

fun main(args: Array<String>) {
    val solution = BuddyStrings()
    val example1 = solution.buddyStrings("ab", "ba")
    assertTrue(example1)

    val example2 = solution.buddyStrings("ab", "ab")
    assertFalse(example2)

    val example3 = solution.buddyStrings("aa", "aa")
    assertTrue(example3)

    val example4 = solution.buddyStrings("abcaa", "abcbb")
    assertFalse(example4)

    val example5 = solution.buddyStrings("ab", "babbb")
    assertFalse(example5)

    val example6 = solution.buddyStrings(
        "asbcsbbcssbssbsbcbbipbybyt",
        "asbbsbbcssbssbsbcbbitbybyt"
    )
    assertFalse(example6)
}