package leetCode.medium

import leetCode.easy.TreeNode
import kotlin.math.abs

class MaximumDifferenceBetweenNodeAncestor {
    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) return 0
        return maxAncestorDiff(root, root.`val`, root.`val`)
    }

    private fun maxAncestorDiff(root: TreeNode?, max: Int, min: Int): Int {
        if (root == null) return max - min

        val newMax = maxOf(max, root.`val`)
        val newMin = minOf(min, root.`val`)

        val left = maxAncestorDiff(root.left, newMax, newMin)
        val right = maxAncestorDiff(root.right, newMax, newMin)

        return maxOf(left, right)
    }
}