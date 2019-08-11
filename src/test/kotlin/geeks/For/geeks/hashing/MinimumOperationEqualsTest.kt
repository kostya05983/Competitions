package geeks.For.geeks.hashing

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinimumOperationEqualsTest {

    @Test
    fun firstTest() {
        val minimumOperationEquals = MinimumOperationEquals()
        assertEquals(3, minimumOperationEquals.solve(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun secondTest() {
        val minimumOperationEquals = MinimumOperationEquals()
        assertEquals(0, minimumOperationEquals.solve(intArrayOf(1, 1, 1, 1)))
    }
}