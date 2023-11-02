package leetCode.medium

import leetCode.easy.TreeNode

class CountNodesEqualToAverageSubtree {
    fun averageOfSubtree(root: TreeNode): Int {
        val result = IntArray(1)
        traverse(root, result)

        return result[0]
    }

    private fun traverse(root: TreeNode, result: IntArray): Pair<Int, Int> {
        val leftResult = root.left?.let { traverse(it, result) } ?: 0 to 0
        val rightResult = root.right?.let { traverse(it, result) } ?: 0 to 0

        val reducedCounter = 1 + leftResult.second + rightResult.second
        val reducedSum = root.`val` + leftResult.first + rightResult.first

        if (reducedSum / reducedCounter == root.`val`) {
            result[0]++
        }

        return reducedSum to reducedCounter
    }
}

fun main(args: Array<String>) {
}