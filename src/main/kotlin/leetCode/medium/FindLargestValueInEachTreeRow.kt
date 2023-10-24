package leetCode.medium

import leetCode.easy.TreeNode

class FindLargestValueInEachTreeRow {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int>()
        traverse(0, root, result)

        return result
    }

    private fun traverse(level: Int, root: TreeNode, result: MutableList<Int>) {
        if (result.size <= level) {
            result.add(root.`val`)
        } else {
            result[level] = maxOf(result[level], root.`val`)
        }

        val left = root.left
        val right = root.right

        if (left != null) {
            traverse(level + 1, left, result)
        }
        if (right != null) {
            traverse(level + 1, right, result)
        }
    }
}