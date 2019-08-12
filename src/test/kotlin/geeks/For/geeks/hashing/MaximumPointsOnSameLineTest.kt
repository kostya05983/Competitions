package geeks.For.geeks.hashing

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MaximumPointsOnSameLineTest {

    @Test
    fun solve() {
        val maximumPointsOnSameLine = MaximumPointsOnSameLine()
        assertEquals(4, maximumPointsOnSameLine.solve(arrayOf(-1 to 1, 0 to 0, 1 to 1, 2 to 2, 3 to 3, 3 to 4)))
    }
}