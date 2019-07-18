package structures

import org.junit.jupiter.api.Test

internal class RedBlackTreeTest {

    @Test
    fun redBlackTree() {
        val redBlackTree = RedBlackTree()
        redBlackTree.insert(10)
        redBlackTree.insert(20)
        redBlackTree.insert(30)
        redBlackTree.insert(15)
        println()
    }
}