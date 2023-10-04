package leetCode.easy

import java.util.LinkedList

class DesignHashMap {
    private var size = 16
    private val buckets = Array(size) { LinkedList<Pair<Int, Int>>() }

    fun put(key: Int, value: Int) {
        val hash = getBucket(key)

        val bucket = buckets[hash]

        if (bucket.isEmpty()) {
            bucket.add(key to value)
        } else {
            val found = bucket.indexOfFirst { it.first == key }
            if (found == -1) {
                bucket.add(key to value)
            } else {
                bucket.removeAt(found)
                bucket.add(key to value)
            }
        }
    }

    fun get(key: Int): Int {
        val hash = getBucket(key)

        val bucket = buckets[hash]


        return bucket.firstOrNull { it.first == key }?.second ?: -1
    }

    fun remove(key: Int) {
        val hash = getBucket(key)

        buckets[hash].removeIf { it.first == key }
    }

    private fun getBucket(key: Int): Int {
        return key.hashCode().rem(size)
    }
}