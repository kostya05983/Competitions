package leetCode.medium

class MaxSumOfPairWithEqualSumOfDigits {

    data class Number(
        val value: Int,
        val sum: Int
    )

    fun maximumSum(nums: IntArray): Int {
        val numbers = nums.map {
            var sum = 0
            var num = it
            while (num > 0) {
                sum += num.rem(10)
                num /= 10
            }
            Number(it, sum)
        }.sortedWith { o1, o2 ->
            if (o1.sum == o2.sum) {
                o1.value.compareTo(o2.value)
            } else o1.sum.compareTo(o2.sum)
        }

        var max = -1
        for (i in 0 until numbers.size - 1) {
            if (numbers[i].sum == numbers[i + 1].sum) {
                max = maxOf(max, numbers[i].value + numbers[i + 1].value)
            }
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = MaxSumOfPairWithEqualSumOfDigits()
//    println(solution.maximumSum(intArrayOf(18, 43, 36, 13, 7)))
//    println(solution.maximumSum(intArrayOf(10, 12, 19, 14)))
    println(
        solution.maximumSum(
            intArrayOf(
                279,
                169,
                463,
                252,
                94,
                455,
                423,
                315,
                288,
                64,
                494,
                337,
                409,
                283,
                283,
                477,
                248,
                8,
                89,
                166,
                188,
                186,
                128
            )
        )
    )
}