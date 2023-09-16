package leetCode.easy

import java.util.*

class MinimumRightShiftsToSortArray {
    fun minimumRightShifts(nums: List<Int>): Int {
        if (nums.size == 1) return 0

        val list = LinkedList(nums)

        val sorted = list.sorted()

        var i = 0
        while (i < list.size) {
            if (list == sorted) return i
            val last = list.removeLast()
            list.addFirst(last)
            i++
        }

        return -1
    }
}