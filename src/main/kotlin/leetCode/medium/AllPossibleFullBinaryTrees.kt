package leetCode.medium

import leetCode.easy.TreeNode

class AllPossibleFullBinaryTrees {
    private val memorization = mutableMapOf<Int, List<TreeNode>>(
        0 to emptyList<TreeNode>(),
        1 to listOf<TreeNode>(TreeNode(0))
    )

    fun allPossibleFBT(n: Int): List<TreeNode?> {
        val memorized = memorization[n]
        if (memorized != null) {
            return memorized
        }

        val result = mutableListOf<TreeNode>()
        for (left in 0 until n) {
            val right = n - 1 - left
            val leftTree = allPossibleFBT(left)
            val rightTree = allPossibleFBT(right)

            for (t1 in leftTree) {
                for (t2 in rightTree) {
                    val node = TreeNode(0).apply {
                        this.left = t1
                        this.right = t2
                    }
                    result.add(node)
                }
            }
        }
        memorization[n] = result

        return result
    }
}

fun main(args: Array<String>) {
    val solution = AllPossibleFullBinaryTrees()
    val result = solution.allPossibleFBT(7)
    println(result)
}