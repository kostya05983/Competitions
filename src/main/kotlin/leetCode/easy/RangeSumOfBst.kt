package leetCode.easy

class RangeSumOfBst {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0

        var count = 0

        if (root.`val` in low..high) {
            count += root.`val`
        }

        count += rangeSumBST(root.left, low, high)
        count += rangeSumBST(root.right, low, high)

        return count
    }
}

fun main(args: Array<String>) {
    val solution = RangeSumOfBst()

    println(solution.rangeSumBST(TreeNode(10).apply {
        left = TreeNode(5).apply {
            left = TreeNode(3)
            right = TreeNode(7)
        }
        right = TreeNode(15).apply {
            right = TreeNode(18)
        }
    }, 7, 15))
}