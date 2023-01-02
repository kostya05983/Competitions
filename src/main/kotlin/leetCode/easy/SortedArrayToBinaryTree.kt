package leetCode.easy


class SortedArrayToBinaryTree {
    fun buildTree(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left>right) return null

        val mid = (left+right)/2
        val temp = TreeNode(nums[mid])

        temp.left = buildTree(nums, left, mid-1)

        temp.right = buildTree(nums, mid+1, right)

        return temp
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildTree(nums, 0, nums.size-1)
    }
}

fun main(args: Array<String>) {
    val result = SortedArrayToBinaryTree().sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    println(result)

}