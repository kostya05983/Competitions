package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Stack

class CousinsInBinaryTree {
    data class NodeInfo(
        val parent: TreeNode?,
        val node: TreeNode,
        val depth: Int
    )

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        if (root == null) return false

        val stack = Stack<NodeInfo>()
        stack.push(NodeInfo(null, root, 0))

        val memory = mutableMapOf<Int, NodeInfo>()

        while (stack.isNotEmpty()) {
            val nodeInfo = stack.pop()
            val (_, node, depth) = nodeInfo

            memory[node.`val`] = nodeInfo

            val left = node.left
            if (left != null) {
                stack.push(NodeInfo(node, left, depth + 1))
            }

            val right = node.right
            if (right != null) {
                stack.push(NodeInfo(node, right, depth + 1))
            }
        }

        val left = memory[x]
        val right = memory[y]

        return left?.parent != null && right?.parent != null && left.parent != right.parent && left.depth == right.depth
    }
}

fun main(args: Array<String>) {
    val solution = CousinsInBinaryTree()
    val example1 = solution.isCousins(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3)
    }, 4, 3)
    assertEquals(false, example1)

    val example2 = solution.isCousins(TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }, 5, 4)
    assertEquals(true, example2)

    val example3 = solution.isCousins(TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(4)
        }
        right = TreeNode(3)
    }, 2, 3)
    assertEquals(false, example3)
}