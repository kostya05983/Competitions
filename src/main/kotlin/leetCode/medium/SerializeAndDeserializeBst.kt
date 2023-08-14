package leetCode.medium

import leetCode.easy.TreeNode
import java.lang.StringBuilder
import java.util.*

class SerializeAndDeserializeBst {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val sb = StringBuilder()

        val stack = Stack<TreeNode?>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val popped = stack.pop()
            sb.append(popped?.`val`).append(",")

            if (popped != null) {
                stack.push(popped.right)
                stack.push(popped.left)
            }
        }

        sb.setLength(sb.length - 1)
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == "") return null
        val splitted = data.split(",")

        return recursive(splitted)
    }

    private var index: Int = 0

    private fun recursive(array: List<String>): TreeNode? {
        if (array[index] == "null") return null

        val root = TreeNode(array[index].toInt())
        index++
        root.left = recursive(array)
        index++
        root.right = recursive(array)

        return root
    }
}

fun main(args: Array<String>) {
    val solution = SerializeAndDeserializeBst()
    val example1 = solution.serialize(TreeNode(2).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(5)
            }
            right = TreeNode(2)
        }
        right = TreeNode(4).apply {
            left = TreeNode(-1)
        }
    })
    println(example1)

    val deserialize = solution.deserialize(example1)
    println(deserialize)
}