package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class NumberOfEquivalentDominoPairs {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val dominoes = dominoes.map { Domino(it[0], it[1]) }

        val result = mutableMapOf<Domino, Int>()
        for (domino in dominoes) {
            if (result.containsKey(domino)) {
                result[domino] = result.getOrDefault(domino, 0) + 1
            } else {
                result[domino] = 0
            }
        }

        return result.map {
            sumN(it.value)
        }.sum()
    }

    private fun sumN(n: Int): Int {
        var result = 0
        var remain = n
        while (remain >= 1) {
            result += remain
            remain--
        }

        return result
    }

    data class Domino(
        val first: Int,
        val second: Int
    ) {
        override fun hashCode(): Int {
            return minOf(first, second).hashCode() + maxOf(first, second).hashCode()
        }

        override fun equals(other: Any?): Boolean {
            if (other !is Domino) return false

            val firstOther = minOf(other.first, other.second)
            val secondOther = maxOf(other.first, other.second)

            return minOf(first, second) == firstOther && maxOf(first, second) == secondOther
        }
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfEquivalentDominoPairs()
    val example1 = solution.numEquivDominoPairs(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )
    )
    assertEquals(1, example1)

    val example2 = solution.numEquivDominoPairs(
        arrayOf(
            intArrayOf(1, 2),//1
            intArrayOf(1, 2),//2
            intArrayOf(1, 1),
            intArrayOf(1, 2),//3
            intArrayOf(2, 2)
        )
    )
    assertEquals(3, example2)
}