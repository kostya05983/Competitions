package leetCode.easy

class ArrayIntersection {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val firstArray = if (nums1.size > nums2.size) nums1 else nums2
        val secondArray = if (nums1.size > nums2.size) nums2 else nums1

        val firstSet = firstArray
        val secondSet = secondArray.toSet()
        val result = mutableSetOf<Int>()

        for (element in firstSet) {
            val number = element
            if (secondSet.contains(number)) {
                result.add(number)
            }
        }

        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    println(ArrayIntersection().intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).toList())
    println(ArrayIntersection().intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).toList())
    println(ArrayIntersection().intersection(intArrayOf(2, 1), intArrayOf(1, 1)).toList())
}