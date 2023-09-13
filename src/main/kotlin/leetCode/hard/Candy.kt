package leetCode.hard

import org.junit.jupiter.api.Assertions.assertEquals

class Candy {
    fun candy(ratings: IntArray): Int {
        var i = 0

        val candies = IntArray(ratings.size) { 1 }
        while (i < ratings.size - 1) {
            val diff = if (ratings[i] < ratings[i + 1]) {
                val newValue = candies[i] + 1
                candies[i + 1] = newValue
                newValue
            } else 1

            var j = i + 1
            while (j != 0 && ratings[j - 1] > ratings[j] && candies[j - 1] <= candies[j]) {
                candies[j - 1] += diff
                j--
            }
            i++
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