package leetCode.medium

import leetCode.easy.TreeNode
import java.util.PriorityQueue
import java.util.Stack

class KthSmallestElementBst {
    private var result: Int = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        recursive(root!!, intArrayOf(k))
        return result
    }

    private fun recursive(root: TreeNode, count: IntArray) {
        val left = root.left
        if (left != null) {
            recursive(left, count)
        }
        count[0]--

        if (count[0] == 0) result = root.`val`

        val right = root.right
        if (right != null) {
            recursive(right, count)
        }
    }
}

fun main(args: Array<String>) {
    val solution = KthSmallestElementBst()
}