package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class CircularArrayLoop {
    fun circularArrayLoop(nums: IntArray): Boolean {
        if (nums.size == 1) return false
        for (i in nums.indices) {
            val num = nums[i]
            if (num == 0) continue

            var slow = i
            var fast = circularIndex(slow + nums[slow], nums.size)
            while (nums[fast] * nums[slow] > 0 && nums[circularIndex(fast + nums[fast], nums.size)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == circularIndex(slow + nums[slow], nums.size)) {
                        break
                    }
                    return true
                }

                slow = circularIndex(slow + nums[slow], nums.size)
                fast = circularIndex(fast + nums[fast], nums.size)
                fast = circularIndex(fast + nums[fast], nums.size)
            }

            slow = i
            val current = nums[i]
            while (nums[slow] * current > 0) {
                val next = circularIndex(slow + nums[slow], nums.size)
                nums[slow] = 0
                slow = next
            }
        }

        return false
    }

    private fun circularIndex(index: Int, n: Int): Int {
        return if (index < 0) {
            n + index.rem(n)
        } else if (index >= n) {
            index.rem(n)
        } else {
            index
        }
    }
}

fun main(args: Array<String>) {
    val solution = CircularArrayLoop()
//    val example1 = solution.circularArrayLoop(intArrayOf(2, -1, 1, 2, 2))
//    assertEquals(true, example1)
//
//    val example2 = solution.circularArrayLoop(intArrayOf(-1, -2, -3, -4, -5, 6))
//    assertEquals(false, example2)
//
//    val example3 = solution.circularArrayLoop(intArrayOf(1, -1, 5, 1, 4))
//    assertEquals(true, example3)
//
//    val example4 = solution.circularArrayLoop(intArrayOf(-2, 1, -1, -2, -2))
//    assertEquals(false, example4)
//
//    val example5 = solution.circularArrayLoop(intArrayOf(2, -1, 1, -2, -2))
//    assertEquals(false, example5)
//
//    val example6 = solution.circularArrayLoop(intArrayOf(2, 2, 2, 2, 2, 4, 7))
//    assertEquals(false, example6)
//
//    val example7 = solution.circularArrayLoop(intArrayOf(1, 1, 2))
//    assertEquals(true, example7)
//
//    val example8 = solution.circularArrayLoop(intArrayOf(2,1,1,-1))
//    assertEquals(false, example8)
//
//    val example9 = solution.circularArrayLoop(intArrayOf(-2,-3,-9))

    val example10 = solution.circularArrayLoop(intArrayOf(-1))
}