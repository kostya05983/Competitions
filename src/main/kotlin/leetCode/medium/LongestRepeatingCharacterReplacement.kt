package leetCode.medium

class LongestRepeatingCharacterReplacement {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0

        val frequencies = IntArray(26)
        var maxCount = 0
        var maxLength = 0

        for (right in s.indices) {
            maxCount = maxOf(maxCount, ++frequencies[s[right] - 'A'])

            while (right - left + 1 - maxCount > k) {
                frequencies[s[left] - 'A']--
                left++
            }
            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}

fun main(args: Array<String>) {
    val solution = LongestRepeatingCharacterReplacement()
    println(solution.characterReplacement("ABAB", 2))
    println(solution.characterReplacement("AABABBA", 1))
    println(solution.characterReplacement("ABABBBBBB", 1))
    println(solution.characterReplacement("ABABBBBBB", 0))
}