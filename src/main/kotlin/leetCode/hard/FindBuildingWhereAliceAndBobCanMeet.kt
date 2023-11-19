package leetCode.hard

import educative.crack.java.interview.stack.Stack
import java.util.*

class FindBuildingWhereAliceAndBobCanMeet {
    data class TreeKey(
        val index: Int,
        val height: Int
    ) : Comparable<TreeKey> {
        override fun compareTo(other: TreeKey): Int {
            return if (index < other.index && height < other.height) {
                1
            } else -1
        }
    }

    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size)

        val nextGreaterElement = nextGreaterElement(heights)

        for (i in 0 until queries.size) {
            var (aliceIndex, bobIndex) = queries[i]
            var aliceCurrentHeight = heights[aliceIndex]
            var bobCurrentHeight = heights[bobIndex]

            if (aliceIndex == bobIndex) {
                result[i] = aliceIndex
                continue
            }

            do {
                val nextAlice = nextGreaterElement[aliceIndex]
                val nextBob = nextGreaterElement[bobIndex]

                if (nextAlice?.first == bobIndex) {
                    result[i] = nextAlice.first
                    break
                }
                if (nextBob.first == aliceIndex) {
                    result[i] = nextBob.first
                    break
                }

                if (nextAlice.first == nextBob.first) {
                    result[i] = nextBob.first
                    break
                }

                if (nextBob.first != -1 && (nextAlice.first == -1 || nextAlice.first > bobIndex)) {
                    bobIndex = nextBob.first
                    bobCurrentHeight = nextBob.second
                }
                if (nextAlice.first != -1 && (nextBob.first == -1 || nextBob.first > aliceIndex)) {
                    aliceIndex = nextAlice.first
                    aliceCurrentHeight = nextAlice.second
                }

            } while (nextAlice.first != -1 || nextBob.first != -1)
        }

        return result
    }

    private fun nextGreaterElement(heights: IntArray): Array<Pair<Int, Int>> {
        val result = Array(heights.size) { Pair(-1, -1) }
        val stack = Stack<Pair<Int, Int>>(heights.size)
        for (i in heights.indices.reversed()) {
            while (!stack.isEmpty && stack.top().second <= heights.get(i)) {
                stack.pop()
            }
            if (!stack.isEmpty) {
                val top = stack.top()
                result[i] = Pair(top.first, top.second)
            }
            stack.push(Pair(i, heights[i]))
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = FindBuildingWhereAliceAndBobCanMeet()
//    println(
//        solution.leftmostBuildingQueries(
//            intArrayOf(6, 4, 8, 5, 2, 7),
//            arrayOf(intArrayOf(0, 1), intArrayOf(0, 3), intArrayOf(2, 4), intArrayOf(3, 4), intArrayOf(2, 2))
//        ).toList()
//    )
    println(
        solution.leftmostBuildingQueries(
            intArrayOf(5, 3, 8, 2, 6, 1, 4, 6),
            arrayOf(intArrayOf(0, 7), intArrayOf(3, 5), intArrayOf(5, 2), intArrayOf(3, 0), intArrayOf(1, 6))
        ).toList()
    )
}