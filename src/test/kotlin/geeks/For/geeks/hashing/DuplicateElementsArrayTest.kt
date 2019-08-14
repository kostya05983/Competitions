package geeks.For.geeks.hashing

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DuplicateElementsArrayTest {

    @Test
    fun solve() {
        val duplicateElementsArray = DuplicateElementsArray()
        assertFalse(duplicateElementsArray.solve(3, intArrayOf(1, 2, 3, 4, 1, 2, 3, 4)))
    }

    @Test
    fun solve1() {
        val duplicateElementsArray = DuplicateElementsArray()
        assertTrue(duplicateElementsArray.solve(3, intArrayOf(1, 2, 3, 1, 4, 5)))
    }

    @Test
    fun solve2() {
        val duplicateElementsArray = DuplicateElementsArray()
        assertFalse(duplicateElementsArray.solve(3, intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun solve3() {
        val duplicateElementsArray = DuplicateElementsArray()
        assertTrue(duplicateElementsArray.solve(3, intArrayOf(1, 2, 3, 4, 4)))
    }
}