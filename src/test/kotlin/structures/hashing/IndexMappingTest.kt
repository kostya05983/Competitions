package structures.hashing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IndexMappingTest {

    @Test
    fun isPresentTest() {
        val a = intArrayOf(-1, 9, -5, -8, -5, -2)
        val indexMapping = IndexMapping()

        indexMapping.insert(a)
        val x = -5
        assertEquals(true, indexMapping.search(x))
    }
}