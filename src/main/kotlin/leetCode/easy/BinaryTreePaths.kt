package leetCode.easy

class BinaryTreePaths {

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()
        if (root == null) return result

        val sb = StringBuilder()

        traversal(root, sb, result)

        return result
    }

    private fun traversal(root: TreeNode, sb: StringBuilder, result: MutableList<String>) {
        sb.append(root.`val`)

        if (root.left == null && root.right == null) {
            result.add(sb.toString())
            return
        }

        if (root.left != null) {
            val length = sb.length
            sb.append("->")
            traversal(root.left!!, sb, result)
            sb.setLength(length)
        }
        if (root.right != null) {
            val length = sb.length
            sb.append("->")
            traversal(root.right!!, sb, result)
            sb.setLength(length)
        }
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