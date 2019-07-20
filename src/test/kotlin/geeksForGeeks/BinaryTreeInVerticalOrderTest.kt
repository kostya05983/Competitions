package geeksForGeeks

import org.junit.jupiter.api.Test

class BinaryTreeInVerticalOrderTest {


    @Test
    fun test() {
        val tree = BinaryTreeInVerticalOrder<Int>()

        tree.insert(1)
        tree.insert(2)
        tree.insert(3)
        tree.insert(4)
        tree.insert(5)
        tree.insert(6)
        tree.insert(7)
        tree.insert(8)
        tree.insert(9)

        println(tree.printVertical())

    }
}