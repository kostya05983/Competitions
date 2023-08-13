package leetCode.medium

import leetCode.easy.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

class MaximumLevelSumOfBinaryTree {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0

        val stack = Stack<Pair<Int, TreeNode>>()
        stack.push(0 to root)

        val levelToSum = mutableMapOf<Int, Int>()

        while (stack.isNotEmpty()) {
            val nodeInfo = stack.pop()
            val (depth, node) = nodeInfo

            levelToSum[depth] = levelToSum.getOrDefault(depth, 0) + node.`val`

            val left = node.left
            if (left != null) {
                stack.push(depth + 1 to left)
            }

            val right = node.right
            if (right != null) {
                stack.push(depth + 1 to right)
            }
        }

        return levelToSum.maxBy { it.value }!!.key + 1
    }
}

fun main(args: Array<String>) {
    val solution = MaximumLevelSumOfBinaryTree()
    val example1 = solution.maxLevelSum(TreeNode(1).apply {
        left = TreeNode(7).apply {
            left = TreeNode(7)
            right = TreeNode(-8)
        }
        right = TreeNode(0)
    })
    assertEquals(2, example1)

    val example2 = solution.maxLevelSum(TreeNode(989).apply {
        left = null
        right = TreeNode(10250).apply {
            left = TreeNode(98693).apply {
                left = null
                right = null
            }
            right = TreeNode(-89388).apply {
                left = null
                right = TreeNode(-32127)
            }
        }
    })
    assertEquals(2, example2)

    val example3 = solution.maxLevelSum(TreeNode(-100).apply {
        left = TreeNode(-200).apply {
            left = TreeNode(-20)
            right = TreeNode(-5)
        }
        right = TreeNode(-300).apply {
            left = TreeNode(-10)
            right = null
        }
    })
    assertEquals(3, example3)
}