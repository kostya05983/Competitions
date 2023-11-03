package leetCode.medium

class MaximumNumberOfOccurrencesOfSubstring {
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        val frequency = IntArray(26)
        var frequencyCount = 0

        val occurences = mutableMapOf<String, Int>()

        var left = 0
        var right = 0

        var rightMax = maxSize
        var leftMax = minSize

        while (right < s.length || left < s.length) {
            if (right < s.length) {
                val increased = ++frequency[s[right] - 'a']
                if (increased == 1) frequencyCount++
            }

            val size = right - left + 1
            if (frequencyCount <= maxLetters && size >= minSize && size <= maxSize) {
                val subString = s.substring(left, right)
                occurences[subString] = occurences.getOrDefault(subString, 0) + 1
            }

            if (right < rightMax && right < s.length) {
                right++
                continue
            }
            if (left < leftMax) {
                val decreased = --frequency[s[left] - 'a']
                if (decreased == 0) frequencyCount--

                left++
                continue
            }
            rightMax += minSize
            leftMax += minSize
        }


        return occurences.maxBy { it.value }.value
    }
}

fun main(args: Array<String>) {
    val solution = MaximumNumberOfOccurrencesOfSubstring()
    println(solution.maxFreq("aababcaab", 2, 3, 4))
    println(solution.maxFreq("aaaa", 1, 3, 3))
}