package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Locale
import java.util.PriorityQueue

class SuperUglyNumber {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val ugly = LongArray(n)
        val idx = IntArray(primes.size)

        ugly[0] = 1
        for (i in 1 until n) {
            ugly[i] = Long.MAX_VALUE

            for (j in primes.indices) {
                ugly[i] = minOf(ugly[i], primes[j] * ugly[idx[j]])
            }

            for (j in primes.indices) {
                if (ugly[i] == primes[j] * ugly[idx[j]]) idx[j]++
            }
        }

        return ugly[n - 1].toInt()
    }
}

fun main(args: Array<String>) {
    val solution = SuperUglyNumber()
    assertEquals(32, solution.nthSuperUglyNumber(12, intArrayOf(2, 7, 13, 19)))

    assertEquals(1, solution.nthSuperUglyNumber(1, intArrayOf(2, 3, 5)))

    assertEquals(4, solution.nthSuperUglyNumber(3, intArrayOf(2)))

    assertEquals(2144153025, solution.nthSuperUglyNumber(5911, intArrayOf(2, 3, 5, 7)))
}