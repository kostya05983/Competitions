package leetCode.easy

import java.util.*

class SecondMinimumNodeInBinaryTree {

    fun findSecondMinimumValue(root: TreeNode?): Int {
        if (root == null) return -1

        val heap = PriorityQueue<Int>()

        val stack = Stack<TreeNode>()
        stack.add(root)

        while (stack.isNotEmpty()) {
            val popped = stack.pop()

            heap.add(popped.`val`)

            popped.left?.let { stack.add(it) }
            popped.right?.let { stack.add(it) }
        }

        val firstValue = heap.poll()

        while (heap.peek() == firstValue) {
            heap.poll()
        }

        return if (heap.peek() == null) -1 else heap.peek()
    }
}

fun main(args: Array<String>) {
    val solution = SecondMinimumNodeInBinaryTree()
    solution.findSecondMinimumValue(TreeNode(5).apply {
        left = TreeNode(8)
        right = TreeNode(5)
    })
}