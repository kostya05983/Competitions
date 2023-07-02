package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.LinkedList

class FindArrayConcatenation {
    fun findTheArrayConcVal(nums: IntArray): Long {
        val linkedList = LinkedList<Int>()
        for (num in nums) {
            linkedList.add(num)
        }

        var sum = 0L
        while (linkedList.isNotEmpty()) {
            val first = linkedList.removeFirst()
            val last = linkedList.lastOrNull()
            sum += last?.let {
                ("$first" + "$last").toInt()
            } ?: first
            if (last != null) linkedList.removeLast()
        }

        return sum
    }
}

fun main(args: Array<String>) {
    val solution = FindArrayConcatenation()
    val example = solution.findTheArrayConcVal(intArrayOf(7, 52, 2, 4))
    assertEquals(596L, example)

    val example1 = solution.findTheArrayConcVal(intArrayOf(5, 14, 13, 8, 12))
    assertEquals(673L, example1)
}