package leetCode.easy

class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()

        if (nums.size == 0) return emptyList()
        if (nums.size == 1) return listOf(nums[0].toString())

        var left = nums[0]
        var right = nums[0]

        for (i in 1 until nums.size) {
            val current = nums[i]

            if (current - right == 1) {
                right = current
                continue
            }

            if (left == right) {
                result.add("$left")
            } else {
                result.add("$left->$right")
            }

            right = current
            left = current
        }

        if (left == right) {
            result.add("$left")
        } else {
            result.add("$left->$right")
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = SummaryRanges()
    val example1 = solution.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7))
    println(example1)
    val example2 = solution.summaryRanges(intArrayOf(0,2,3,4,6,8,9))
    println(example2)
}