package leetCode.easy

class FindKOrAnArray {
    fun findKOr(nums: IntArray, k: Int): Int {
        var result = 0

        var currentK = 0
        while (true) {

            var count = 0
            var isGreateEveryone = true

            val powed = Math.pow(2.0, currentK.toDouble()).toInt()
            for (num in nums) {
                if (powed.and(num) == powed) {
                    count++
                }
                if (powed < num) {
                    isGreateEveryone = false
                }
            }

            if (count >= k) {
                result = result.or(powed)
            }

            if (isGreateEveryone) break

            currentK++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = FindKOrAnArray()
    println(solution.findKOr(intArrayOf(7, 12, 9, 8, 9, 15), 4))
    println(solution.findKOr(intArrayOf(2, 12, 1, 11, 4, 5), 6))
    println(solution.findKOr(intArrayOf(10, 8, 5, 9, 11, 6, 8), 1))
    println(solution.findKOr(intArrayOf(22, 7, 27, 30, 15, 30, 28), 4))
    println(
        solution.findKOr(
            intArrayOf(
                14, 1, 2, 28, 4, 15, 3, 12
            ), 2
        )
    )
}