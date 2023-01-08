package leetCode.easy

import java.util.*

class BinaryTreePostorderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        traverse(root, result)

        return result
    }

    private fun traverse(root: TreeNode?, result: MutableList<Int>) {
        if (root == null) return

        traverse(root.left, result)
        traverse(root.right, result)

        result.add(root.`val`)
    }
}