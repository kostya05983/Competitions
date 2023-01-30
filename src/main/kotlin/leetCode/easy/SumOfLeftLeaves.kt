package leetCode.easy

class SumOfLeftLeaves {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0
        return traverse(root, true)
    }

    private fun traverse(node: TreeNode?, isRight: Boolean): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null && !isRight) {
            return node.`val`
        }

        return traverse(node.left, false) + traverse(node.right, true)
    }
}