package leetCode.hard

import java.util.TreeMap

class NumberOfFlowersInFullBloom {
    fun fullBloomFlowers(flowers: Array<IntArray>, people: IntArray): IntArray {
        val startedArray = flowers.map { it[0] }.sorted()
        val endedArray = flowers.map { it[1] }.sorted()

        val binaryStartedTree = TreeMap<Int, Int>()
        for (i in startedArray.indices) {
            binaryStartedTree[startedArray[i]] = i + 1
        }
        val binaryEndTree = TreeMap<Int, Int>()
        for (i in endedArray.indices) {
            binaryEndTree[endedArray[i] + 1] = i + 1
        }

        val result = IntArray(people.size)
        for (i in people.indices) {
            val started = binaryStartedTree.floorEntry(people[i])?.value ?: 0
            val ended = binaryEndTree.floorEntry(people[i])?.value ?: 0

            result[i] = started - ended
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfFlowersInFullBloom()
    println(
        solution.fullBloomFlowers(
            arrayOf(intArrayOf(1, 6), intArrayOf(3, 7), intArrayOf(9, 12), intArrayOf(4, 13)),
            intArrayOf(2, 3, 7, 11)
        ).toList()
    )
    println(
        solution.fullBloomFlowers(
            arrayOf(intArrayOf(19, 37), intArrayOf(19, 38), intArrayOf(19, 35)),
            intArrayOf(6, 7, 21, 1, 13, 37, 5, 37, 46, 43)
        ).toList()
    )
}