package leetCode.easy

import java.util.*

class BinaryTreePreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode>()
        val result = mutableListOf<Int>()

        var current = root
        while (current != null) {
            result.add(current.`val`)
            stack.push(current)

            current = current.left
            while (current == null && stack.isNotEmpty()) {
                val el = stack.pop()
                current = el.right
            }
        }

        return result
    }
}