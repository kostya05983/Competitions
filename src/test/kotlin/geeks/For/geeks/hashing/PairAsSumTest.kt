package geeks.For.geeks.hashing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class PairAsSumTest {


    @Test
    fun standardCase() {
        val a = intArrayOf(1, 4, 45, 6, 10, 8)
        val n = 16
        val solver = PairAsSum()

        assertEquals("Pair 10 and 6", solver.solve(a, n))
    }
}