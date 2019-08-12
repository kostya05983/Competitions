package geeks.For.geeks.hashing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MaximumDisBetTwoOccurTest {

    @Test
    fun solve() {
        val maximumDisBetTwoOccur = MaximumDisBetTwoOccur()
        assertEquals(10, maximumDisBetTwoOccur.solve(intArrayOf(3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2)))
    }
}