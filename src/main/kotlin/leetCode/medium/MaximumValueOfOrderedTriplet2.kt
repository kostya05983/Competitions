package leetCode.medium


class MaximumValueOfOrderedTriplet2 {

    fun maximumTripletValue(nums: IntArray): Long {
        var result = 0L
        var diff = 0L
        var max = 0L
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (i > 1) result = maxOf(num * diff, result)
            if (i > 0) diff = maxOf(max - num, diff)

            if (nums[i] > max) max = num.toLong()

        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MaximumValueOfOrderedTriplet2()

    val example1 = solution.maximumTripletValue(intArrayOf(12, 6, 1, 2, 7))
    println(example1)

    val example2 = solution.maximumTripletValue(intArrayOf(44, 12, 6, 1, 2, 7))
    println(example2)

    val example3 = solution.maximumTripletValue(intArrayOf(1, 10, 3, 4, 19))
    println(example3)

    val example4 = solution.maximumTripletValue(intArrayOf(13, 10, 3, 4, 19))
    println(example4)

    val example5 = solution.maximumTripletValue(intArrayOf(1000000, 1, 1000000))
    println(example5)

    val example6 = solution.maximumTripletValue(intArrayOf(18, 15, 8, 13, 10, 9, 17, 10, 2, 16, 17))
    println(example6)

    val example7 = solution.maximumTripletValue(intArrayOf(6, 11, 12, 12, 7, 9, 2, 11, 12, 4, 19, 14, 16, 8, 16))
    println(example7)
}