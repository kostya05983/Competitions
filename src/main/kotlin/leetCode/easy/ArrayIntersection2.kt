package leetCode.easy

class ArrayIntersection2 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val firstArray = if (nums1.size > nums2.size) nums1 else nums2
        val secondArray = if (nums1.size > nums2.size) nums2 else nums1


        val firstArraySet = mutableMapOf<Int, Int>()
        for (element in firstArray) {
            firstArraySet[element] = firstArraySet.getOrDefault(element, 0) + 1
        }

        val result = mutableListOf<Int>()
        for (element in secondArray) {
            if (firstArraySet.contains(element) && firstArraySet[element] != 0) {
                result.add(element)
                firstArraySet[element] = firstArraySet[element]!! - 1
            }
        }

        return result.toIntArray()
    }
}


fun main(args: Array<String>) {
    println(ArrayIntersection2().intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).toList())
    println(ArrayIntersection2().intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).toList())
    println(ArrayIntersection2().intersect(intArrayOf(2, 1), intArrayOf(1, 1)).toList())
}