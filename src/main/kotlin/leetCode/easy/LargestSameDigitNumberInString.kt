package leetCode.easy

class LargestSameDigitNumberInString {
    fun largestGoodInteger(num: String): String {
        var left = 0
        var right = 3

        var max = Int.MIN_VALUE
        while (right <= num.length) {
            val substring = num.substring(left, right)
            val distinct = substring.toList().distinct()
            if (distinct.size == 1) max = maxOf(max, substring.toInt())
            left++
            right++
        }


        return when (max) {
            Int.MIN_VALUE -> ""
            0 -> "000"
            else -> max.toString()
        }
    }
}

fun main(args: Array<String>) {
    val solution = LargestSameDigitNumberInString()
    println(solution.largestGoodInteger("6777133339"))
    println(solution.largestGoodInteger("2300019"))
    println(solution.largestGoodInteger("42352338"))
    println(solution.largestGoodInteger("222"))
}