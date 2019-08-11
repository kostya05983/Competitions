package geeks.For.geeks.hashing

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinimumDeleteTest {

    @Test
    fun testFromGeeks() {
        val minimum = MinimumDelete()
        assertEquals(2, minimum.solve(intArrayOf(4, 3, 4, 4, 2, 4)))
    }

    @Test
    fun secondTestFromGeeks() {
        val minimum = MinimumDelete()
        assertEquals(4, minimum.solve(intArrayOf(1, 2, 3, 4, 5)))
    }
}