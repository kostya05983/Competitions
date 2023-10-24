package leetCode.easy

class ConstructStringFromBinaryTree {
    fun tree2str(root: TreeNode?): String {
        if (root == null) return ""

        val sb = StringBuilder()

        traverse(root, sb)

        return sb.toString().substring(1, sb.length - 1)
    }

    private fun traverse(root: TreeNode, sb: StringBuilder) {
        sb.append("(${root.`val`}")
        val left = root.left
        val right = root.right

        if (left != null) {
            traverse(left, sb)
        }

        if (right != null) {
            if (left == null) {
                sb.append("()")
            }
            traverse(right, sb)
        }

        sb.append(")")
    }
}