package leetCode.easy

class FindModeBinaryTree {
    fun findMode(root: TreeNode?): IntArray {
        requireNotNull(root)

        val frequencies = HashMap<Int, Int>()
        traverse(frequencies, root)

        return frequencies.map { it }.groupBy { it.value }.maxBy { it.key }.value.map { it.key }.toIntArray()
    }

    private fun traverse(frequencies: HashMap<Int, Int>, root: TreeNode) {
        val left = root.left
        val right = root.right

        frequencies[root.`val`] = frequencies.getOrDefault(root.`val`, 0) + 1

        left?.let { traverse(frequencies, left) }
        right?.let { traverse(frequencies, right) }
    }
}

fun main(args: Array<String>) {
    val solution = FindModeBinaryTree()
    println(solution.findMode(TreeNode(1).apply {
        left = null
        right = TreeNode(2).apply {
            left = TreeNode(2)
        }
    }).toList())

    println(solution.findMode(TreeNode(1).apply {
        left = null
        right = TreeNode(2)
    }).toList())
}