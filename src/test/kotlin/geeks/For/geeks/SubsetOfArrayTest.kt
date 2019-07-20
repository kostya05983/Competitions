package geeks.For.geeks

import geeks.For.geeks.hashing.SubsetOfArray
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SubsetOfArrayTest {

    @Test
    fun subArrayFound() {
        val array = intArrayOf(1, 2, 3, 4)
        val subarray = intArrayOf(2, 3)

        val subsetOfArray = SubsetOfArray()

        assertTrue(subsetOfArray.subArray(subarray, array))
    }

    @Test
    fun subArrayNotFound() {
        val array = intArrayOf(1, 2, 3, 4)
        val subarray = intArrayOf(5, 6)

        val subsetOfArray = SubsetOfArray()

        assertFalse(subsetOfArray.subArray(subarray, array))
    }
}