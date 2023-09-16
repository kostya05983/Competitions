package leetCode.medium

import java.util.*
import kotlin.collections.HashMap

class MinimumArrayLengthAfterPairRemovals {
    data class Frequency(
        val startIndex: Int,
        val value: Int,
        val freq: Int
    ) : Comparable<Frequency> {
        override fun compareTo(other: Frequency): Int {
            return freq.compareTo(other.freq)
        }
    }

    fun minLengthAfterRemovals(nums: List<Int>): Int {
        val deletedList = BooleanArray(nums.size)
        var left = 0
        var right = nums.size - 1

        var currentSize = nums.size
        val frequencyHeap = PriorityQueue<Frequency>(Collections.reverseOrder())

        val map = HashMap<Int, Int>()
        val mapIndex = HashMap<Int, Int>()
        for (i in nums.indices) {
            val num = nums[i]
            map[num] = map.getOrDefault(num, 0) + 1
            mapIndex[num] = i
        }
        map.forEach { (key, value) ->
            frequencyHeap.add(Frequency(startIndex = mapIndex[key]!! - (value - 1), key, value))
        }

        while (left < right) {
            if (deletedList[left]) {
                left++
                continue
            }
            if (deletedList[right]) {
                right--
                continue
            }

            val peek = frequencyHeap.peek() ?: break

            if (nums[left] < peek.value) {
                val polled = frequencyHeap.poll()
                currentSize -= 2
                deletedList[left] = true
                deletedList[polled.startIndex + polled.freq - 1] = true
                if (polled.freq != 1) {
                    frequencyHeap.add(polled.copy(freq = polled.freq - 1))
                }
            } else {
                frequencyHeap.poll()
                continue
            }

            left++
        }

        return currentSize
    }
}