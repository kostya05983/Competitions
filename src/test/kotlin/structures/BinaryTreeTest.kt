package structures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeTest {

    @Test
    fun insertTest() {
        val binaryTree = BinaryTree<Int>()
        binaryTree.insert(7)
        binaryTree.insert(11)
        binaryTree.insert(10)
        binaryTree.insert(9)
        binaryTree.insert(8)
        binaryTree.insert(15)
        assertEquals("7 11 10 9 8 15 ", binaryTree.preOrder())
    }

    @Test
    fun deleteTest() {
        val binaryTree = BinaryTree<Int>()
        binaryTree.insert(8)
        binaryTree.insert(10)
        binaryTree.insert(14)
        binaryTree.insert(3)
        binaryTree.insert(6)
        binaryTree.insert(7)
        binaryTree.insert(1)
        binaryTree.insert(4)
        binaryTree.insert(13)
        assertEquals("1 3 4 6 7 8 10 13 14 ", binaryTree.inOrder())
        binaryTree.delete(13)
        assertEquals("1 3 4 6 7 8 10 14 ", binaryTree.inOrder())
        binaryTree.delete(14)
        assertEquals("1 3 4 6 7 8 10 ", binaryTree.inOrder())
    }
}