package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MinimumDeletionsMakeCharacterFrequencies {
    fun minDeletions(s: String): Int {
        val charToFrequency = HashMap<Char, Int>()

        var max = 0
        for (ch in s) {
            val newFrequency = charToFrequency.getOrDefault(ch, 0) + 1
            max = maxOf(max, newFrequency)
            charToFrequency[ch] = newFrequency
        }
        val frequencyToChar = HashMap<Int, Char>()

        var result = 0
        for (entry in charToFrequency) {
            if (frequencyToChar.contains(entry.value)) {
                var current = entry.value
                while (current != 0 && frequencyToChar.contains(current)) {
                    current--
                    result++
                }
                frequencyToChar[current] = entry.key
                continue
            }
            frequencyToChar[entry.value] = entry.key
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MinimumDeletionsMakeCharacterFrequencies()
    val example1 = solution.minDeletions("aab")
    assertEquals(0, example1)

    val example2 = solution.minDeletions("aaabbbcc")
    assertEquals(2, example2)

    val example3 = solution.minDeletions("ceabaacb")
    assertEquals(2, example3)
}