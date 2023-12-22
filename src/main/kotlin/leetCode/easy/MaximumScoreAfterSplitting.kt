package leetCode.easy

class MaximumScoreAfterSplitting {
    fun maxScore(s: String): Int {
        var oneCount = 0
        for (ch in s) {
            if (ch == '1') {
                oneCount++
            }
        }

        var currentZeroCount = 0
        var currentOneCount = 0

        var maxScore = 0

        for (i in 0 until s.length) {
            val ch = s[i]

            if (i != 0) {
                val score = (oneCount - currentOneCount) + currentZeroCount
                maxScore = maxOf(score, maxScore)
            }

            when (ch) {
                '1' -> {
                    currentOneCount++
                }

                else -> {
                    currentZeroCount++
                }
            }
        }

        return maxScore
    }
}

fun main(args: Array<String>) {
    val solution = MaximumScoreAfterSplitting()
    println(solution.maxScore("011101"))
}