package geeks.For.geeks.hashing

import java.util.*
import kotlin.collections.HashSet

class IntersectionTwoLinkedList(list1: LinkedList<Int>, private val list2: LinkedList<Int>) {

    private val hash: HashSet<Int> = HashSet()

    init {
        hash.addAll(list1)
    }


    fun findIntersection(): String {
        val sb = StringBuilder()

        for (element in list2) {
            if (hash.contains(element)) {
                sb.append(element).append(" ")
            }
        }
        return sb.toString()
    }

    fun getUnion(): String {
        val sb = StringBuilder()

        hash.addAll(list2)

        for (element in hash) {
            sb.append(element).append(" ")
        }
        return sb.toString()
    }


}