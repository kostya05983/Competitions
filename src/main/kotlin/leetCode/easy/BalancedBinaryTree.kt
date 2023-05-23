package leetCode.easy

import kotlin.math.abs

class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true

        return traverse(root) != -1L
    }

    private fun traverse(root: TreeNode?): Long {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1

        val left = traverse(root.left)
        if (left == -1L) return -1
        val right = traverse(root.right)
        if (right == -1L) return -1

        if (abs(left - right) > 1) return -1

        return 1 + Math.max(left, right)
    }
}

fun main(args: Array<String>) {
    val solution = BalancedBinaryTree()
    val example = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    require(solution.isBalanced(example))

    val example2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4)
                right = TreeNode(4)
            }
            right = TreeNode(3)
        }
        right = TreeNode(2)
    }

    require(!solution.isBalanced(example2)) { "Wrong!" }

    val example3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }
    require(!solution.isBalanced(example3)) { "Wrong!" }

    val example4 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4)
            }
        }
        right = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4)
            }
        }
    }
    require(!solution.isBalanced(example4)) { "Wrong!" }
}