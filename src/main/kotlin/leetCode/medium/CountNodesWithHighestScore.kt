package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class CountNodesWithHighestScore {
    data class BinaryTreeNode(
        var subtreeSize: Int = 0,
        var score: Int = 0,
        var left: BinaryTreeNode? = null,
        var right: BinaryTreeNode? = null
    )

    class Tree(
        private val parents: IntArray
    ) {
        private val treeArray: Array<BinaryTreeNode>
        private val size: Int

        init {
            val arr = Array(parents.size) {
                BinaryTreeNode()
            }

            for (i in 1 until parents.size) {
                val parentId = parents[i]

                if (arr[parentId].left == null) {
                    arr[parentId].left = arr[i]
                } else {
                    arr[parentId].right = arr[i]
                }
            }

            initSize(arr[0])

            treeArray = arr
            size = parents.size
        }

        private fun initSize(root: BinaryTreeNode?): Int {
            if (root == null) return 0

            val size = initSize(root.left) + initSize(root.right) + 1
            root.subtreeSize = size
            return size
        }

        fun highestScore(): Int {
            var highest = 0
            for (i in parents.indices) {
                var score = 1
                val leftSize = treeArray[i].left?.subtreeSize ?: 0
                val rightSize = treeArray[i].right?.subtreeSize ?: 0
                val restSize = size - 1 - leftSize - rightSize

                if (leftSize > 0) {
                    score *= leftSize
                }

                if (rightSize > 0) {
                    score *= rightSize
                }

                if (restSize > 0) {
                    score *= restSize
                }
                treeArray[i].score = score
                highest = maxOf(highest, score)
            }

            var count = 0
            for (i in parents.indices) {
                if (treeArray[i].score == highest) {
                    count++
                }
            }

            return count
        }
    }

    fun countHighestScoreNodes(parents: IntArray): Int {
        val tree = Tree(parents)
        return tree.highestScore()
    }
}

fun main(args: Array<String>) {
    val solution = CountNodesWithHighestScore()
    val example1 = solution.countHighestScoreNodes(intArrayOf(-1, 2, 0, 2, 0))
    assertEquals(3, example1)

    val example2 = solution.countHighestScoreNodes(intArrayOf(-1, 2, 0))
    assertEquals(2, example2)
}