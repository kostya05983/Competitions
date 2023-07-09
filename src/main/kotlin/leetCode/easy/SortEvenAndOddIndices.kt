package leetCode.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import java.util.PriorityQueue

class SortEvenAndOddIndices {
    fun sortEvenOdd(nums: IntArray): IntArray {
        val even = PriorityQueue<Int> { a, b -> (a - b) }
        val odd = PriorityQueue<Int> { a, b -> (b - a) }

        for (i in 0 until nums.size) {
            val num = nums[i]
            if (i.rem(2) == 0) {
                even.add(num)
            } else {
                odd.add(num)
            }
        }

        for (i in nums.indices) {
            if (i.rem(2) == 0) {
                nums[i] = even.poll()
            } else {
                nums[i] = odd.poll()
            }
        }

        return nums
    }
}

fun main(args: Array<String>) {
    val solution = SortEvenAndOddIndices()
    val example1 = solution.sortEvenOdd(intArrayOf(4, 1, 2, 3))
    assertArrayEquals(intArrayOf(2, 3, 4, 1), example1)

    val example2 = solution.sortEvenOdd(intArrayOf(2, 1))
    assertArrayEquals(intArrayOf(2, 1), example2)
}