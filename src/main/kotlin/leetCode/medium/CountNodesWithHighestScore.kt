package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class CountNodesWithHighestScore {
    data class BinaryTreeNode(
        var subtreeSize: Int,
        val number: Int,
        var left: BinaryTreeNode?,
        var right: BinaryTreeNode?,
        var parent: BinaryTreeNode?
    )

    class Tree(
        parents: IntArray
    ) {
        lateinit var root: BinaryTreeNode

        init {
            val map = mutableMapOf<Int, BinaryTreeNode>()
            for (i in parents.indices) {
                map[i] = BinaryTreeNode(1, i, null, null, null)
            }

            for (i in parents.indices) {
                if (parents[i] == -1) {
                    root = map[i]!!
                } else {
                    val ptr = requireNotNull(map[parents[i]])
                    val child = requireNotNull(map[i])
                    if (ptr.left != null) {
                        ptr.right = child
                    } else {
                        ptr.left = child
                    }
                    child.parent = ptr

                    val childSize = child.subtreeSize

                    var secondPtr = ptr
                    while (secondPtr.parent != null) {
                        secondPtr.subtreeSize += childSize
                        secondPtr = secondPtr.parent!!
                    }
                    secondPtr.subtreeSize += childSize
                }
            }
        }

        var maxCount = 1

        fun highestScore(root: BinaryTreeNode = this.root, max: Int = 0): Int {
            var max = max

            val diffRoot = if (this.root != root) (this.root.subtreeSize - root.subtreeSize) else 1

            val left = root.left
            val right = root.right

            //leaf case
            if (left == null && right == null) {
                val score = this.root.subtreeSize - 1

                if (max == score) {
                    maxCount++
                } else if (max < score) {
                    max = score
                    maxCount = 1
                }
            }

            if (left != null && right == null || left == null && right != null) {
                val score = diffRoot * requireNotNull(
                    root.left?.subtreeSize
                        ?: root.right?.subtreeSize
                )

                if (max == score) {
                    maxCount++
                } else if (max < score) {
                    max = score
                    maxCount = 1
                }
            }

            if (left != null && right != null) {
                val score = diffRoot * left.subtreeSize * right.subtreeSize

                if (max == score) {
                    maxCount++
                } else if (max < score) {
                    max = score
                    maxCount = 1
                }
            }

            max = maxOf(root.left?.let { highestScore(it, max) } ?: 0, max)
            max = maxOf(root.right?.let { highestScore(it, max) } ?: 0, max)

            return max
        }
    }

    fun countHighestScoreNodes(parents: IntArray): Int {
        val tree = Tree(parents)
        tree.highestScore()
        return tree.maxCount
    }
}

fun main(args: Array<String>) {
    val solution = CountNodesWithHighestScore()
    val example1 = solution.countHighestScoreNodes(intArrayOf(-1, 2, 0, 2, 0))
    assertEquals(3, example1)

    val example2 = solution.countHighestScoreNodes(intArrayOf(-1, 2, 0))
    assertEquals(2, example2)
}