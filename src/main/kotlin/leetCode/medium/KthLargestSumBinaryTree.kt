package leetCode.medium

import leetCode.easy.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

class KthLargestSumBinaryTree {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        if (root == null) return 0

        val maxHeap = PriorityQueue<Long>()

        val queue = LinkedList<TreeNode?>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            var sum = 0L

            for (i in 0 until queue.size) {
                val node = queue.poll()
                sum += node!!.`val`

                val left = node.left
                if (left != null) {
                    queue.offer(left)
                }

                val right = node.right
                if (right != null) {
                    queue.offer(right)
                }
            }

            if (maxHeap.size < k) {
                maxHeap.offer(sum)
            } else if (maxHeap.peek() < sum) {
                maxHeap.poll()
                maxHeap.offer(sum)
            }
        }

        if (maxHeap.size < k) return -1

        return maxHeap.peek()
    }
}

fun main(args: Array<String>) {
    val solution = KthLargestSumBinaryTree()
    val example1 = solution.kthLargestLevelSum(TreeNode(5).apply {
        left = TreeNode(8).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(6)
            }
            right = TreeNode(1)
        }
        right = TreeNode(9).apply {
            left = TreeNode(3)
            right = TreeNode(7)
        }
    }, 2)
    assertEquals(13, example1)

    val example2 = solution.kthLargestLevelSum(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }, 1)
    assertEquals(3, example2)
}

