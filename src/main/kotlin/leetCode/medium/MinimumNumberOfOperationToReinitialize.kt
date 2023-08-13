package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MinimumNumberOfOperationToReinitialize {

    fun reinitializePermutation(n: Int): Int {
        val permutationArray = IntArray(n) { it -> it }
        TODO()
    }
}

fun main(args: Array<String>) {
    val solution = MinimumNumberOfOperationToReinitialize()
    val example1 = solution.reinitializePermutation(2)
    assertEquals(1, example1)

    val example2 = solution.reinitializePermutation(4)
    assertEquals(2, example2)

    val example3 = solution.reinitializePermutation(6)
    assertEquals(4, example3)
}