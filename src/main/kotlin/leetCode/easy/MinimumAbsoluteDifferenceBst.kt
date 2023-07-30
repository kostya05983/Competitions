package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.abs

class MinimumAbsoluteDifferenceBst {
    fun getMinimumDifference(root: TreeNode): Int {
        val left = root.left
        val right = root.right

        if (left == null && right == null) {
            return Int.MAX_VALUE
        }

        val leftMin = if (left != null) {
            minOf(abs(root.`val` - getHighestElement(left)), getMinimumDifference(left))
        } else Int.MAX_VALUE

        val rightMin = if (right != null) {
            minOf(abs(root.`val` - getLowestElement(right)), getMinimumDifference(right))
        } else Int.MAX_VALUE

        return minOf(leftMin, rightMin)
    }

    private tailrec fun getLowestElement(root: TreeNode): Int {
        return if (root.left != null) {
            getLowestElement(root.left!!)
        } else root.`val`
    }

    private tailrec fun getHighestElement(root: TreeNode): Int {
        return if (root.right != null) {
            getHighestElement(root.right!!)
        } else root.`val`
    }
}

fun main(args: Array<String>) {
    val solution = MinimumAbsoluteDifferenceBst()
    val example1 = solution.getMinimumDifference(TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(6)
    })
    assertEquals(1, example1)

    val example2 = solution.getMinimumDifference(TreeNode(236).apply {
        left = TreeNode(104).apply {
            left = null
            right = TreeNode(227)
        }
        right = TreeNode(701).apply {
            left = null
            right = TreeNode(911)
        }
    })
    assertEquals(9, example2)

//    solution.getMinimumDifference()
}