package leetCode.medium

import leetCode.easy.TreeNode
import java.util.*

class CousinsInBinaryTree2 {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val stack = Stack<NodeInfo>()
        stack.push(NodeInfo(null, root, 0))

        val levelToSum = mutableMapOf<Int, Int>()

        while (stack.isNotEmpty()) {
            val nodeInfo = stack.pop()
            val (_, node, depth) = nodeInfo

            levelToSum[depth] = levelToSum.getOrDefault(depth, 0) + node.`val`

            val left = node.left
            if (left != null) {
                stack.push(NodeInfo(node, left, depth + 1))
            }

            val right = node.right
            if (right != null) {
                stack.push(NodeInfo(node, right, depth + 1))
            }
        }

        stack.push(NodeInfo(null, root, 0))

        val memory = mutableMapOf<TreeNode, Int>()
        while (stack.isNotEmpty()) {
            val nodeInfo = stack.pop()
            val (parent, node, depth) = nodeInfo

            if (depth < 2) {
                node.`val` = 0
            } else {
                val memorized = memory[nodeInfo.parent]
                if (memorized != null) {
                    nodeInfo.node.`val` = memorized
                } else {
                    val sum = levelToSum[depth]!!
                    val newValue = sum - ((parent?.left?.`val` ?: 0) + (parent?.right?.`val` ?: 0))
                    nodeInfo.node.`val` = newValue
                    parent?.let {
                        memory[parent] = newValue
                    }
                }

            }

            val left = node.left
            if (left != null) {
                stack.push(NodeInfo(node, left, depth + 1))
            }

            val right = node.right
            if (right != null) {
                stack.push(NodeInfo(node, right, depth + 1))
            }
        }

        return root
    }

    data class NodeInfo(
        val parent: TreeNode?,
        val node: TreeNode,
        val depth: Int
    )
}

fun main(args: Array<String>) {
    val solution = CousinsInBinaryTree2()
    val example1 = solution.replaceValueInTree(TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(1)
            right = TreeNode(10)
        }
        right = TreeNode(9).apply {
            right = TreeNode(7)
        }
    })
    println(example1)

    val example2 = solution.replaceValueInTree(TreeNode(3).apply {
        left = TreeNode(1)
        right = TreeNode(2)
    })
    println(example2)
}