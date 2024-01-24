package leetCode.medium

import leetCode.easy.TreeNode


class PseudoPalindromicPathsInBinaryTree {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        if (root == null) return 0

        return dp(root, 0)
    }

    private fun dp(root: TreeNode?, path: Int): Int {
        if (root == null) return 0

        val left = root.left
        val right = root.right

        val newPath = path.xor(1.shl(root.`val`))

        if (left == null && right == null) {
            return if (newPath.and(newPath - 1) == 0) 1
            else 0
        }

        val leftResult = left?.let {
            dp(left, newPath)
        } ?: 0
        val rightResult = right?.let {
            dp(right, newPath)
        } ?: 0

        return leftResult + rightResult
    }
}

fun main(args: Array<String>) {
    val solution = PseudoPalindromicPathsInBinaryTree()

    println(solution.pseudoPalindromicPaths(TreeNode(2).apply {
        left = TreeNode(3).apply {
            left = TreeNode(3)
            right = TreeNode(1)
        }
        right = TreeNode(1).apply {
            right = TreeNode(1)
        }
    }))
}