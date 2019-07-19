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
}