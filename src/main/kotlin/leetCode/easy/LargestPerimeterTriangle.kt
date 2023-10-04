package leetCode.easy

import java.util.Collections
import java.util.PriorityQueue

class LargestPerimeterTriangle {
    fun largestPerimeter(nums: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder()).also {
            it.addAll(nums.toList())
        }

        while (maxHeap.size >= 3) {
            val max = maxHeap.poll()
            val secondMax = maxHeap.poll()
            val thirdMax = maxHeap.peek()

            if (secondMax + thirdMax > max) {
                return secondMax + thirdMax + max
            } else {
                maxHeap.add(secondMax)
            }
        }

        return 0
    }
}