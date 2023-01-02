package leetCode.easy

import java.util.Stack

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class InorderTraversal {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode>()
        val result = mutableListOf<Int>()

        var current = root
        while (current != null) {
            stack.push(current)
            current = current.left
            while (current == null && stack.isNotEmpty()) {
                val el = stack.pop()
                result.add(el.`val`)
                current = el.right
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(InorderTraversal().inorderTraversal(TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }))
}