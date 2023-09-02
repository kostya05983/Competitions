package leetCode.hard

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

class CountKSubsequencesStringWithMaximumBeauty {
    fun countKSubsequencesWithMaxBeauty(s: String, k: Int): Int {
        val frequencies = mutableMapOf<Char, Int>()
        for (ch in s) {
            frequencies[ch] = frequencies.getOrDefault(ch, 0) + 1
        }

        val heap = PriorityQueue<Int>(Collections.reverseOrder())
        for (entry in frequencies) {
            heap.add(entry.value)
        }

        var result = 1L

        var remainK = k
        while (heap.isNotEmpty()) {
            val frequency = heap.poll()
            var count = 1

            while (heap.peek() == frequency) {
                count++
                heap.poll()
            }

            if (count > remainK) {
                result *= combination(count, remainK)

                var temp = 1
                for (i in 0 until remainK) {
                    temp *= frequency
                }

                return (result * temp).rem(1000000000 + 7).toInt()
            }

            for (i in 0 until count) {
                result *= frequency
                result = result.rem(1000000000 + 7)
            }

            remainK -= count
        }

        return if (remainK != 0) 0 else result.rem(1000000000 + 7).toInt()
    }

    private fun combination(n: Int, m: Int): Long {
        var result = 1L
        val mFactorial = factorial(m)
        for (i in n downTo n - m + 1) {
            result *= i
        }
        return result / mFactorial
    }

    private fun factorial(n: Int): Long {
        var result = 1L
        for (i in 2..n) {
            result *= i
        }
        return result
    }
}

fun main(args: Array<String>) {
    val solution = CountKSubsequencesStringWithMaximumBeauty()
//    val example1 = solution.countKSubsequencesWithMaxBeauty("bcca", 2)
//    assertEquals(4, example1)
//////
//    val example2 = solution.countKSubsequencesWithMaxBeauty("abbcd", 4)
//    assertEquals(2, example2)
//
//    val example3 = solution.countKSubsequencesWithMaxBeauty("abc", 2)
//    assertEquals(3, example3)
////
//    val example4 = solution.countKSubsequencesWithMaxBeauty("auy", 1)
//    assertEquals(3, example4)
//
//    val example5 = solution.countKSubsequencesWithMaxBeauty("dfyq", 2)
//    assertEquals(6, example5)
//
//    val example6 = solution.countKSubsequencesWithMaxBeauty("abbcd", 4)
//    assertEquals(2, example6)
//
//    val example7 = solution.countKSubsequencesWithMaxBeauty("dpdemprzvz", 1)
//    assertEquals(6, example7)
//
//    val example8 = solution.countKSubsequencesWithMaxBeauty("jyuhiyzjuk", 2)
//    assertEquals(12, example8)

//    val example9 = solution.countKSubsequencesWithMaxBeauty("iewvwmocnrqfuxa", 12)
//    assertEquals(156, example9)

    val example10 = solution.countKSubsequencesWithMaxBeauty(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc",
        3
    )
    assertEquals(73741817, example10)
}