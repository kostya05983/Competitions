package structures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HashMapTest {

    @Test
    fun insert() {
        val hashMap = HashMap<String, Int>()

        hashMap.insert("test", 2)
        hashMap.insert("test1", 3)

        assertEquals(2, hashMap.get("test"))
        assertEquals(3, hashMap.get("test1"))
    }
}