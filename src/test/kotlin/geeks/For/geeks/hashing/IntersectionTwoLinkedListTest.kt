package geeks.For.geeks.hashing

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class IntersectionTwoLinkedListTest {

    private fun createStruct(): IntersectionTwoLinkedList {
        val list1 = LinkedList<Int>()
        list1.add(10)
        list1.add(15)
        list1.add(4)
        list1.add(20)
        val list2 = LinkedList<Int>()
        list2.add(8)
        list2.add(4)
        list2.add(2)
        list2.add(10)

        return IntersectionTwoLinkedList(list1, list2)
    }

    @Test
    fun findIntersection() {
        val intersectionTwoLinkedList = createStruct()
        assertEquals("4 10 ", intersectionTwoLinkedList.findIntersection())
    }

    @Test
    fun getUnion() {
        val intersectionTwoLinkedList = createStruct()
        assertEquals("2 4 20 8 10 15 ", intersectionTwoLinkedList.getUnion())
    }
}