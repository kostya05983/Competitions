package leetCode.easy

class LargestOddNumberInString {
    fun largestOddNumber(num: String): String {
        var lastIndexOdd = -1

        for (i in 0 until num.length) {
            val num = num[i] - '0'

            if (num.rem(2) == 1) {
                lastIndexOdd = i
            }
        }

        return when (lastIndexOdd) {
            -1 -> ""
            else -> num.substring(0, lastIndexOdd + 1)
        }
    }
}

fun main(args: Array<String>) {
    val solution = LargestOddNumberInString()

    println(solution.largestOddNumber("52"))
    println(solution.largestOddNumber("4206"))
    println(solution.largestOddNumber("35427"))
}