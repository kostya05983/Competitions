package leetCode.hard

import org.junit.jupiter.api.Assertions.assertEquals

class Candy {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 }

        for (i in 1 until candies.size) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1
        }

        for (i in candies.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) candies[i] = maxOf(candies[i], candies[i + 1] + 1)
        }

        return candies.sum()
    }
}

fun main(args: Array<String>) {
    val solution = Candy()
    val example1 = solution.candy(intArrayOf(1, 0, 2))
    assertEquals(5, example1)

    val example2 = solution.candy(intArrayOf(1, 2, 2))
    assertEquals(4, example2)
}