package leetCode.easy

import java.util.Stack

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` != q?.`val`) {
            return false
        }

        val leftTreeStack = Stack<TreeNode>()
        val rightTreeStack = Stack<TreeNode>()

        var currentLeft = p
        var currentRight = q
        while (currentLeft != null || currentRight != null) {
            leftTreeStack.push(currentLeft)
            rightTreeStack.push(currentRight)

            if (currentLeft?.`val` != currentRight?.`val`) {
                return false
            }

            currentLeft = currentLeft?.left
            currentRight = currentRight?.left


            while (currentLeft == null && currentRight == null && leftTreeStack.isNotEmpty() && rightTreeStack.isNotEmpty()) {
                val elLeft = leftTreeStack.pop()
                val elRight = rightTreeStack.pop()
                currentLeft = elLeft.right
                currentRight = elRight.right
            }
        }

        if (leftTreeStack.isNotEmpty() || rightTreeStack.isNotEmpty()) {
            return false
        }

        return true
    }
}

fun main(args: Array<String>) {
    println(SameTree().isSameTree(TreeNode(1), TreeNode(1).apply {
        right = TreeNode(2)
    }))
}