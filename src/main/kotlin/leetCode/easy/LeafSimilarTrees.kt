package leetCode.easy

class LeafSimilarTrees {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val firstSequence = mutableListOf<Int>()
        val secondSequence = mutableListOf<Int>()

        getLeafSequence(root1, firstSequence)
        getLeafSequence(root2, secondSequence)

        return firstSequence == secondSequence
    }

    private fun getLeafSequence(root: TreeNode?, leafSequence: MutableList<Int>) {
        if (root == null) return
        val left = root.left
        val right = root.right
        if (left == null && right == null) {
            leafSequence.add(root.`val`)
        }

        getLeafSequence(left, leafSequence)
        getLeafSequence(right, leafSequence)
    }
}

fun main(args: Array<String>) {
    val solution = LeafSimilarTrees()
    println(solution.leafSimilar(TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }, TreeNode(1).apply {
        left = TreeNode(3)
        right = TreeNode(2)
    }))
}