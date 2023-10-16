package leetCode.easy

import java.lang.StringBuilder

class CalculateDigitSumOfString {
    fun digitSum(s: String, k: Int): String {
        val sb = StringBuilder()

        if (s.length <= k) return s

        var count = 0
        var sum = 0
        for (ch in s) {
            sum += ch.digitToInt()
            count++
            if (count == k) {
                sb.append(sum.toString())
                sum = 0
                count = 0
            }
        }
        if (count != 0) sb.append(sum.toString())

        return digitSum(sb.toString(), k)
    }
}

fun main(args: Array<String>) {
    println(CalculateDigitSumOfString().digitSum("11111222223", 3))
}