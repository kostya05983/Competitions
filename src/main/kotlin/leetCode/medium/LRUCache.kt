package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class LRUCache(private val capacity: Int) {
    private var leastRecentlyUsedKey = 0

    private var leastRecentlyCycleBuffer = IntArray(capacity) { -1 }
    private var leastPointer = 0

    //2,5,9,

    private val keyToValue = HashMap<Int, Int>()

    fun get(key: Int): Int {
        if (key > keyToValue.size) throw IllegalArgumentException("Key is more than capacity")

        leastRecentlyUsedKey = key
        return keyToValue[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if (keyToValue.size == capacity) {
            keyToValue.remove(leastRecentlyUsedKey)
        }
        keyToValue[key] = value
    }
}

fun main(args: Array<String>) {
    val solution = LRUCache(2)
    solution.put(1, 1)
    solution.put(2, 2)
    assertEquals(1, solution.get(1))
    solution.put(3, 3)
    assertEquals(-1, solution.get(2))
    solution.put(4, 4)
    assertEquals(-1, solution.get(1))
    assertEquals(3, solution.get(3))
    assertEquals(4, solution.get(4))
}