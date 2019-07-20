package structures.hashing

import kotlin.math.abs


internal class IndexMapping {

    private val MAX = 1000

    val hash = Array(MAX + 1) { BooleanArray(2) }


    fun search(x: Int): Boolean {
        return if (x < 0) {
            hash[abs(x)][1]
        } else {
            hash[x][0]
        }
    }

    fun insert(x: Int) {
        if (x < 0) {
            hash[x][1] = true
        } else {
            hash[x][0] = false
        }
    }

    fun insert(a: IntArray) {
        for (i in 0 until a.size) {
            if (a[i] < 0) {
                hash[abs(a[i])][1] = true
            } else {
                hash[abs(a[i])][0] = true
            }
        }
    }
}