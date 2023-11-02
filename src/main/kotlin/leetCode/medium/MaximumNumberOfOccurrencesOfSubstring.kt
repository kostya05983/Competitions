package leetCode.medium

class MaximumNumberOfOccurrencesOfSubstring {
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        val frequency = IntArray(26)
        var frequencyCount = 0

        var left = 0
        var right = minSize

        var rightMax = maxSize
        var leftMax = minSize

        while (right < s.length) {
            //todo вычисления частотности


            if (right < rightMax) {
                right++
                continue
            }
            if (left < leftMax) {
                left++
                continue
            }
            rightMax = rightMax + (maxSize - minSize)
            leftMax = leftMax + (maxSize - minSize)
        }

    }
}

fun main(args: Array<String>) {
    val solution = MaximumNumberOfOccurrencesOfSubstring()
    println(solution.maxFreq("aababcaab", 2, 3, 4))
    println(solution.maxFreq("aaaa", 1, 3, 3))
}