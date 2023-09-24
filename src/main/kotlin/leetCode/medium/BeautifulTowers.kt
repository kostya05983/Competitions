package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.TreeMap

class BeautifulTowers {
    fun maximumSumOfHeights(maxHeights: List<Int>): Long {
        var max = 0L

        val rightMemory = getRightMemory(maxHeights)
        val leftMemory = getLeftMemory(maxHeights)

        for (startPoint in maxHeights.indices) {
            val current = maxHeights[startPoint].toLong()

            val rightSum = rightMemory.getOrDefault(startPoint, 0) - maxHeights[startPoint]
            val leftSum = leftMemory.getOrDefault(startPoint, 0) - maxHeights[startPoint]

            max = maxOf(leftSum + rightSum + current, max)
        }

        return max
    }

    private fun getLeftMemory(maxHeights: List<Int>): Map<Int, Long> {
        val leftMemory = mutableMapOf<Int, Long>()
        var current = 0L
        val leftArray = IntArray(maxHeights.size) { maxHeights[it] }
        val binary = TreeMap<Int, Int>()
        for (i in maxHeights.indices) {
            val left = leftArray.getOrNull(i - 1)
            if (left != null) {
                if (left <= leftArray[i]) {
                    current += leftArray[i]
                    leftMemory[i] = current
                } else {
                    val leftNearestMinKey = binary.floorKey(leftArray[i])

                    if (leftNearestMinKey == null) {
                        current = leftArray[i].toLong() * (i + 1)
                    } else {
                        val leftNearestMinIndex = binary[leftNearestMinKey]!!
                        current = leftArray[i].toLong() * (i - leftNearestMinIndex) + leftMemory[leftNearestMinIndex]!!
                    }

                    leftMemory[i] = current
                }
            } else {
                current += leftArray[i]
                leftMemory[i] = current
            }
            binary[leftArray[i]] = i

            while (true) {
                val key = binary.ceilingKey(leftArray[i] + 1) ?: break
                binary.remove(key)
            }
        }

        return leftMemory
    }

    private fun getRightMemory(maxHeights: List<Int>): Map<Int, Long> {
        val rightMemory = mutableMapOf<Int, Long>()
        var current = 0L
        val rightArray = IntArray(maxHeights.size) { maxHeights[it] }
        val binary = TreeMap<Int, Int>()
        for (i in rightArray.size - 1 downTo 0) {
            val right = rightArray.getOrNull(i + 1)
            if (right != null) {
                if (right <= rightArray[i]) {
                    current += rightArray[i]
                    rightMemory[i] = current
                } else {
                    val rightNearestMinKey = binary.floorKey(rightArray[i])

                    if (rightNearestMinKey == null) {
                        current = rightArray[i].toLong() * (rightArray.size - i)
                    } else {
                        val rightNearestMinIndex = binary[rightNearestMinKey]!!
                        current =
                            rightArray[i].toLong() * (rightNearestMinIndex - i) + rightMemory[rightNearestMinIndex]!!
                    }

                    rightMemory[i] = current
                }
            } else {
                current += rightArray[i]
                rightMemory[i] = current
            }
            binary[rightArray[i]] = i

            while (true) {
                val key = binary.ceilingKey(rightArray[i] + 1) ?: break
                binary.remove(key)
            }
        }

        return rightMemory
    }
}

fun main(args: Array<String>) {
    val solution = BeautifulTowers()
    val example1 = solution.maximumSumOfHeights(listOf(5, 3, 4, 1, 1))
    assertEquals(13, example1)

    val example2 = solution.maximumSumOfHeights(listOf(6, 5, 3, 9, 2, 7))
    assertEquals(22, example2)

    val example3 = solution.maximumSumOfHeights(listOf(3, 2, 5, 5, 2, 3))
    assertEquals(18, example3)

    val example4 = solution.maximumSumOfHeights(listOf(1, 5, 2, 5, 6, 4, 6, 3, 4, 5))
    assertEquals(33, example4)

    val example5 = solution.maximumSumOfHeights(
        listOf(
            528947205,
            446572672,
            245562434,
            29067688,
            230940022,
            237916991,
            546243960,
            898360263,
            110809423,
            616740838,
            141189952,
            272319413,
            173945434,
            944209607,
            709147298,
            291516002,
            697109513,
            945372506,
            321357175,
            271013697,
            140905315,
            154122459,
            745184252,
            379717676,
            468969774,
            302949377,
            261867781,
            933328834,
            791272529,
            583341139,
            83259489,
            304055888,
            873655860,
            808520318,
            194518325,
            703266873,
            281331446,
            927210596,
            422874036,
            902047413,
            774474564,
            809609201,
            493545785,
            415250991,
            884864225,
            392444408,
            610159103,
            903379193,
            816412790,
            591760883,
            361140449,
            759810143,
            588717612,
            694204370,
            42665571,
            517507625,
            702706955,
            952884579
        )
    )
    assertEquals(11903251647, example5)
}