package leetCode.easy

import java.util.Collections
import java.util.PriorityQueue

class NumberOfDistinctAverages {
    fun distinctAverages(nums: IntArray): Int {
        val minHeap = PriorityQueue(nums.toList())
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder()).also {
            it.addAll(nums.toList())
        }

        val result = mutableSetOf<Double>()
        var i = 0
        while (i < nums.size / 2) {
            val min = minHeap.poll()
            val max = maxHeap.poll()

            result.add((min + max) / 2.0)

            i++
        }

        return result.size
    }
}