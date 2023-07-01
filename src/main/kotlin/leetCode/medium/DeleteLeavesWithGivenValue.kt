package leetCode.medium

import leetCode.easy.TreeNode
import java.util.Stack

class DeleteLeavesWithGivenValue {
    fun removeLeafNodesIterative(root: TreeNode, target: Int): TreeNode? {
        val stack = Stack<TreeNode>()

        var current: TreeNode? = root
        var visited: TreeNode? = null
        val parentMap = HashMap<TreeNode, TreeNode>()
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                val left = current.left
                if (left != null) parentMap[left] = current

                current = current.left
            }

            current = stack.peek()
            if (current.right == null || current?.right == visited) {
                current = stack.pop()
                if (current?.`val` == target && current.left == null && current.right == null) {
                    val parent = parentMap[current] ?: return null
                    if (parent.left == current) {
                        parent.left = null
                    }
                    if (parent.right == current) {
                        parent.right = null
                    }
                }
                visited = current
                current = null
            } else {
                val right = current.right
                if (right != null && current != null) parentMap[right] = current

                current = current?.right
            }
        }

        return root
    }

    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if (root?.left != null) root.left = removeLeafNodes(root.left, target)
        if (root?.right != null) root.right = removeLeafNodes(root.right, target)

        return if (root?.left == null && root?.right == null && target == root?.`val`) null else root
    }
}

fun main(args: Array<String>) {
    val solution = DeleteLeavesWithGivenValue()
    val example1 = solution.removeLeafNodes(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2)
        }
        right = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
    }, 2)
    println(example1)

    val example2 = solution.removeLeafNodes(TreeNode(1).apply {
        left = TreeNode(3).apply {
            left = TreeNode(3)
            right = TreeNode(2)
        }
        right = TreeNode(3)
    }, 3)
    println(example2)

    val example3 = solution.removeLeafNodes(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2).apply {
                left = TreeNode(2)
            }
        }
    }, 2)
    println(example3)

    val example4 = solution.removeLeafNodes(TreeNode(1).apply {
        left = TreeNode(1)
        right = TreeNode(1)
    }, 1)
    println(example4)
}