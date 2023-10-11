package leetCode.medium

import kotlin.math.abs

class MaximizeConfusionExam {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        var trueQuestions = 0
        var falseQuestions = 0

        var maxLength = 0
        var left = 0
        for (right in answerKey.indices) {
            if (answerKey[right] == 'T') trueQuestions++ else falseQuestions++

            while (right - left + 1 - maxOf(trueQuestions, falseQuestions) > k) {
                if (answerKey[left] == 'T') trueQuestions-- else falseQuestions--
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}

fun main(args: Array<String>) {
    val solution = MaximizeConfusionExam()
    println(solution.maxConsecutiveAnswers("TTFF", 2))
    println(solution.maxConsecutiveAnswers("TFFT", 1))
    println(solution.maxConsecutiveAnswers("TTFTTFTT", 1))
}