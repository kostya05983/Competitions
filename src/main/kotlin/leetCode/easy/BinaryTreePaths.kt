package leetCode.easy

import java.util.Stack

class BinaryTreePaths {

    enum class VisitedTreeState {
        NONE,
        LEFT,
        BOTH
    }

    data class Node(
        val node: TreeNode,
        var state: VisitedTreeState,
        val length: Int
    )

    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return emptyList()

        val result = mutableListOf<String>()

        val sb = StringBuilder()
        sb.append(root.`val`)

        val stack = Stack<Node>()
        stack.push(Node(root, VisitedTreeState.NONE, sb.length))

        while (stack.isNotEmpty()) {
            val node = stack.peek()
            val treeNode = node.node

            sb.setLength(node.length)

            if (treeNode.left == null && treeNode.right == null) {
                result.add(sb.toString())

                stack.pop()
                continue
            }

            val left = treeNode.left
            if (left != null && node.state == VisitedTreeState.NONE) {
                node.state = VisitedTreeState.LEFT

                sb.append("->")
                sb.append(left.`val`)

                stack.add(Node(left, VisitedTreeState.NONE, sb.length))

                continue
            }

            val right = treeNode.right
            if (right != null && node.state != VisitedTreeState.BOTH) {
                node.state = VisitedTreeState.BOTH

                sb.append("->")
                sb.append(right.`val`)

                stack.add(Node(right, VisitedTreeState.NONE, sb.length))

                continue
            }
            stack.pop()
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = BinaryTreePaths()

    val example1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(5)
        }
        right = TreeNode(3)
    }
    val result1 = solution.binaryTreePaths(example1)

    println(result1)
    require(result1.size == 2) { "Failed first test case $result1" }
    require(result1.containsAll(listOf("1->2->5", "1->3"))) { "Failed first test case $result1" }

    val example2 = TreeNode(1)
    val result2 = solution.binaryTreePaths(example2)
    println(result2)
    require(result2.contains("1")) { "Failed second test case $result2" }
}