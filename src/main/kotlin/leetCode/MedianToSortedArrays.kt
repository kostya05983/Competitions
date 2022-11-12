package leetCode

import kotlin.math.min

class MedianTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val a = if (nums1.size < nums2.size) {
            nums1
        } else nums2
        val b = if (nums1.size < nums2.size) {
            nums2
        } else nums1

        val total = (a.size + b.size)
        val half = (total + 1) / 2

        var left = 0
        var right = a.size

        while (left <= right) {
            val i = (left + right) / 2
            val j = half - i

            val aLeft = a.getOrElse(i - 1) { Integer.MIN_VALUE }
            val bLeft = b.getOrElse(j - 1) { Integer.MIN_VALUE }

            val aRight = a.getOrElse(i) { Integer.MAX_VALUE }
            val bRight = b.getOrElse(j) { Integer.MAX_VALUE }

            if (aLeft <= bRight && bLeft <= aRight) {
                return if (total.rem(2) == 0) {
                    (maxOf(aLeft, bLeft) + minOf(aRight, bRight)) / 2.0

                } else {
                    maxOf(aLeft, bLeft).toDouble()
                }
            } else if (aLeft > bRight) {
                right = i - 1
            } else {
                left = i + 1
            }
        }
        return 0.0
    }

}

fun main(args: Array<String>) {
    println(MedianTwoSortedArrays().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3,4)))
}