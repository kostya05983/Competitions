package leetCode.medium

import java.util.*

class GroupThePeopleGivenGroupSizeTheyBelongTo {
    data class Pair(
        val place: Int,
        val size: Int
    ) : Comparable<Pair> {
        override fun compareTo(other: Pair): Int {
            return this.size.compareTo(other.size)
        }
    }

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val heap = PriorityQueue<Pair>(Collections.reverseOrder())
        for (i in groupSizes.indices) {
            heap.add(Pair(i, groupSizes[i]))
        }

        val result = mutableListOf<List<Int>>()
        var groupResult = mutableListOf<Int>()
        while (heap.isNotEmpty()) {
            val polled = heap.poll()
            groupResult.add(polled.place)

            if (groupResult.size == polled.size) {
                result.add(groupResult)
                groupResult = mutableListOf()
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = GroupThePeopleGivenGroupSizeTheyBelongTo()
    println(solution.groupThePeople(intArrayOf(3, 3, 3, 3, 3, 1, 3)))

    println(solution.groupThePeople(intArrayOf(2, 1, 3, 3, 3, 2)))
}