package leetCode.easy

class MinimumSumOfFourDigits {
    fun minimumSum(num: Int): Int {
        val firstDigit = num / 1000
        val secondDigit = num.rem(1000) / 100
        val thirdDigit = num.rem(100) / 10
        val fourthDigit = num.rem(10)

        val result = mutableListOf(firstDigit, secondDigit, thirdDigit, fourthDigit)
        result.sort()

        if (result[0] == 0 && result[1] != 0) return result[3] + (result[1] * 10 + result[2])
        if (result[0] == 0 && result[1] == 0 && result[2] != 0) return result[2] + result[3]
        if (result[0] == 0 && result[1] == 0 && result[2] == 0) return result[3]


        return result[0] * 10 + result[2] + result[1] * 10 + result[3]
    }
}

fun main(args: Array<String>) {
    println(MinimumSumOfFourDigits().minimumSum(2932))
    println(MinimumSumOfFourDigits().minimumSum(4009))
}