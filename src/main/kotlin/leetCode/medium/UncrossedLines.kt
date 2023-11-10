package leetCode.medium

import java.util.PriorityQueue

class UncrossedLines {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val positionNums1 = HashMap<Int, PriorityQueue<Int>>()
        val positionNums2 = HashMap<Int, PriorityQueue<Int>>()

        for (i in nums1.indices) {
            val num = nums1[i]
            val value = positionNums1.getOrDefault(num, PriorityQueue())
            value.add(i)
            positionNums1[num] = value
        }

        for (i in nums2.indices) {
            val num = nums2[i]
            val value = positionNums2.getOrDefault(num, PriorityQueue())
            value.add(i)
            positionNums2[num] = value
        }

        var i = 0

        var count = 0
        while (i < nums1.size || i < nums2.size) {
            val num1 = nums1.getOrNull(i)
            val num2 = nums2.getOrNull(i)

            val num1Positions = num1?.let { positionNums1[num1] }

            var num1Position = -1
            while (num1Positions != null && num1Positions.isNotEmpty() && num1Position < i) {
                num1Position = num1Positions.poll().takeIf { it > i } ?: -1
            }

            val num2Positions = num2?.let { positionNums2[num2] }

            var num2Position = -1
            while (num2Positions != null && num2Positions.isNotEmpty() && num2Position < i) {
                num2Position = num2Positions.poll().takeIf { it > i } ?: -1
            }

            if (num1Position == -1 && num2Position == -1) {
                i++
                continue
            }

            if (num1Position < num2Position) {
                i = num1Position
                count++
            } else {
                i = num2Position
                count++
            }

            i++
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = UncrossedLines()
    println(solution.maxUncrossedLines(intArrayOf(1, 4, 2), intArrayOf(1, 2, 4)))

    println(solution.maxUncrossedLines(intArrayOf(2, 5, 1, 2, 5), intArrayOf(10, 5, 2, 1, 5, 2)))
}