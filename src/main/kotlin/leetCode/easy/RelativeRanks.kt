package leetCode.easy

import java.util.Collections
import java.util.PriorityQueue

class RelativeRanks {
    fun findRelativeRanks(score: IntArray): Array<String> {
        if (score.size == 1) return score.map { "Gold Medal" }.toTypedArray()

        val heap = PriorityQueue<Int>(Collections.reverseOrder())
        for (item in score) {
            heap.add(item)
        }
        val associateMap = score.mapIndexed { index, i ->
            Pair(i, index)
        }.toMap()

        val result = Array(score.size) { "" }
        var i = 0
        while (heap.isNotEmpty()) {
            val value = heap.poll()
            val text = when (i) {
                0 -> {
                    "Gold Medal"
                }

                1 -> {
                    "Silver Medal"
                }

                2 -> {
                    "Bronze Medal"
                }

                else -> {
                    "${i + 1}"
                }
            }
            val index = associateMap[value]!!
            result[index] = text
            i++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = RelativeRanks()
    val test1 = solution.findRelativeRanks(intArrayOf(5, 4, 3, 2, 1))
    require(test1[0] == "Gold Medal")
    require(test1[1] == "Silver Medal")
    require(test1[2] == "Bronze Medal")
    require(test1[3] == "4")
    require(test1[4] == "5")

    val test2 = solution.findRelativeRanks(intArrayOf(10, 3, 8, 9, 4))
    require(test2[0] == "Gold Medal")
    require(test2[1] == "5")
    require(test2[2] == "Bronze Medal")
    require(test2[3] == "Silver Medal")
    require(test2[4] == "4")
}