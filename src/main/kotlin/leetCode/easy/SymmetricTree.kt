package leetCode.easy

import java.util.*

class SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean {
        val p = root?.left
        val q = root?.right

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
            currentRight = currentRight?.right


            while (currentLeft == null && currentRight == null && leftTreeStack.isNotEmpty() && rightTreeStack.isNotEmpty()) {
                val elLeft = leftTreeStack.pop()
                val elRight = rightTreeStack.pop()
                currentLeft = elLeft.right
                currentRight = elRight.left
            }
        }

        if (leftTreeStack.isNotEmpty() || rightTreeStack.isNotEmpty()) {
            return false
        }

        return true
    }
}

fun main(args: Array<String>) {
    println()
}