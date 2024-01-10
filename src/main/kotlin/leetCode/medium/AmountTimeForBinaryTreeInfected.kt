package leetCode.medium

import leetCode.easy.TreeNode

class AmountTimeForBinaryTreeInfected {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        val infectedTime = mutableMapOf<Int, Int>()
        val start = intArrayOf(start)
        infectionTime(root, start, null, infectedTime)

        return infectedTime.maxOf { it.value }
    }

    private fun infectionTime(root: TreeNode?, start: IntArray, parent: TreeNode?, infected: MutableMap<Int, Int>) {
        if (root == null) return
        val value = root.`val`

        val time = infected[value]
        if (time != null) return

        if (value == start[0]) {
            start[0] = -1
        }

        if (start[0] == -1) {
            val parentTime = parent?.let { infected[it.`val`] } ?: -1
            val leftTime = root.left?.let { infected[it.`val`] } ?: -1
            val rightTime = root.right?.let { infected[it.`val`] } ?: -1

            val nearTime = maxOf(parentTime, leftTime, rightTime)

            infected[value] = nearTime + 1
        }

        infectionTime(root.left, start, root, infected)
        infectionTime(root.right, start, root, infected)
        if (start[0] == -1) infectionTime(parent, start, root, infected)
    }
}

fun main(args: Array<String>) {
    val solution = AmountTimeForBinaryTreeInfected()
    println(solution.amountOfTime(TreeNode(1).apply {
        left = TreeNode(5).apply {
            right = TreeNode(4).apply {
                left = TreeNode(9)
                right = TreeNode(2)
            }
        }
        right = TreeNode(3).apply {
            left = TreeNode(10)
            right = TreeNode(6)
        }
    }, 3))

    println(solution.amountOfTime(TreeNode(1), 1))
    println(solution.amountOfTime(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(5)
                }
            }
        }
    }, 4))
    println(solution.amountOfTime(TreeNode(2).apply {
        left = TreeNode(5)
    }, 5))
}