package leetCode.easy

class NextGreaterElement {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        var i = 0

        val map = nums2.mapIndexed { index, it -> Pair(it, index + 1) }.toMap()

        while (i < nums1.size) {
            var temp = nums1[i]

            var j = map[temp] ?: throw IllegalStateException("equal element must exist")

            while (j < nums2.size) {
                if (nums2[j] > temp) {
                    temp = nums2[j]
                    break
                }
                j++
            }
            nums1[i] = if (nums1[i] == temp) {
                -1
            } else temp

            i++
        }

        return nums1
    }
}

fun main(args: Array<String>) {
    val solution = NextGreaterElement()
    val test1 = solution.nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
    require(test1.contentEquals(intArrayOf(-1, 3, -1)))

    val test2 = solution.nextGreaterElement(intArrayOf(2, 4), intArrayOf(1, 2, 3, 4))
    require(test2.contentEquals(intArrayOf(3, -1)))
}