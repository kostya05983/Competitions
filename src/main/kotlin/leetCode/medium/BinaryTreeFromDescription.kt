package leetCode.medium

import leetCode.easy.TreeNode

class BinaryTreeFromDescription {
    data class TreeInfo(
        var isChild: Boolean,
        var value: TreeNode
    )

    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val hashMap = mutableMapOf<Int, TreeInfo>()

        for ((parentVal, childVal, isLeftVal) in descriptions) {
            var parent = hashMap[parentVal]
            if (parent == null) parent = TreeInfo(false, TreeNode(parentVal))

            var child = hashMap[childVal]
            if (child == null) child = TreeInfo(true, TreeNode(childVal))
            child.isChild = true

            val isLeft = isLeftVal == 1
            if (isLeft) {
                parent.value.left = child.value
            } else {
                parent.value.right = child.value
            }

            hashMap[parentVal] = parent
            hashMap[childVal] = child
        }

        return hashMap.asSequence().firstOrNull {
            !it.value.isChild
        }?.value?.value
    }
}

fun main(args: Array<String>) {
    val solution = BinaryTreeFromDescription()
    val example1 = solution.createBinaryTree(
        arrayOf(
            intArrayOf(20, 15, 1),
            intArrayOf(20, 17, 0),
            intArrayOf(50, 20, 1),
            intArrayOf(50, 80, 0),
            intArrayOf(80, 19, 1)
        )
    )
    val example2 = solution.createBinaryTree(
        arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 0),
            intArrayOf(3, 4, 1)
        )
    )
    println(example2)
}
