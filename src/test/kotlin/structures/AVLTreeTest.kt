package structures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AVLTreeTest {

    @Test
    fun testInsert() {
        val avlTree = AVLTree<Int>()
        avlTree.insert(10)
        avlTree.insert(20)
        avlTree.insert(30)
        avlTree.insert(40)
        avlTree.insert(50)
        avlTree.insert(25)
        assertEquals("30 20 10 25 40 50 ", avlTree.preOrder())
    }

    @Test
    fun testDelete() {
        val avlTree = AVLTree<Int>()
        avlTree.insert(9)
        avlTree.insert(5)
        avlTree.insert(10)
        avlTree.insert(0)
        avlTree.insert(6)
        avlTree.insert(11)
        avlTree.insert(-1)
        avlTree.insert(1)
        avlTree.insert(2)
        assertEquals("9 1 0 -1 5 2 6 10 11 ", avlTree.preOrder())
        avlTree.delete(10)
        assertEquals("1 0 -1 9 5 2 6 11 ", avlTree.preOrder())
    }
}