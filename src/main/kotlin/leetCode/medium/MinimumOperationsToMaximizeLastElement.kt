package leetCode.medium


class MinimumOperationsToMaximizeLastElement {
    fun minOperations(nums1: IntArray, nums2: IntArray): Int {
        var nums1Last = nums1.last()
        var nums2Last = nums2.last()

        var max1 = nums1[0]
        var max2 = nums2[0]

        val notSatisfied = mutableListOf<Int>()
        for (i in 0 until nums1.size - 1) {
            if (nums1[i] > nums1Last || nums2[i] > nums2Last) notSatisfied.add(i)
            max1 = maxOf(max1, nums1[i])
            max2 = maxOf(max2, nums2[i])
        }
        if (notSatisfied.isEmpty()) return 0

        var minOperations = Int.MAX_VALUE
        var wasBreak = false
        for (i in notSatisfied) {
            if (nums2[i] > nums1Last) {
                wasBreak = true
                break
            }
            if (nums1[i] > nums2Last) {
                wasBreak = true
                break
            }
        }
        if (!wasBreak) {
            minOperations = notSatisfied.size
        }


        var result = 0

        if (max1 > nums1Last && max1 > nums2Last || max2 > nums1Last && max2 > nums2Last) return -1

        val temp = nums2Last
        nums2Last = nums1Last
        nums1Last = temp
        result++

        val indexes = mutableListOf<Int>()
        for (i in 0 until nums1.size - 1) {
            if (nums1[i] > nums1Last || nums2[i] > nums2Last) indexes.add(i)
        }

        for (i in indexes) {
            if (nums2[i] > nums1Last) return -1
            if (nums1[i] > nums2Last) return -1
        }


        return if (minOperations < (indexes.size + result)) {
            minOperations
        } else {
            indexes.size + result
        }
    }
}

fun main(args: Array<String>) {
    val solution = MinimumOperationsToMaximizeLastElement()
    println(solution.minOperations(intArrayOf(1, 2, 7), intArrayOf(4, 5, 3)))
    println(solution.minOperations(intArrayOf(2, 3, 4, 5, 9), intArrayOf(8, 8, 4, 4, 4)))
    println(solution.minOperations(intArrayOf(1, 5, 4), intArrayOf(2, 5, 3)))
    println(solution.minOperations(intArrayOf(1, 5, 15), intArrayOf(1, 1, 1)))
    println(solution.minOperations(intArrayOf(1, 1, 8, 9), intArrayOf(1, 7, 1, 1)))
    println(
        solution.minOperations(
            intArrayOf(
                9,
                12,
                2,
                4,
                13,
                1,
                8,
                17,
                14,
                11,
                15,
                14,
                8,
                18,
                1,
                20,
                20,
                6,
                14,
                10,
                1,
                10,
                9,
                3,
                20,
                19,
                18
            ), intArrayOf(12, 16, 3, 8, 4, 19, 18, 11, 13, 12, 9, 9, 3, 2, 2, 12, 17, 7, 14, 18, 2, 8, 19, 6, 8, 16, 20)
        )
    )
}