package leetCode.easy

class FindTheDifferenceOfTwoArrays {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val nums1Set = nums1.toSet()
        val nums2Set = nums2.toSet()

        val result1 = mutableSetOf<Int>()
        for (element in nums1) {
            if (!nums2Set.contains(element)) {
                result1.add(element)
            }
        }

        val result2 = mutableSetOf<Int>()
        for (element in nums2) {
            if (!nums1Set.contains(element)) {
                result2.add(element)
            }
        }

        return listOf(result1.toList(), result2.toList())
    }
}

fun main(args: Array<String>) {
    println(FindTheDifferenceOfTwoArrays().findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6)))
    println(FindTheDifferenceOfTwoArrays().findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2)))
}