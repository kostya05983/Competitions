package yandex.interview

import leetCode.medium.Node
import java.lang.StringBuilder

fun printBeautify(nums: IntArray): String {
    nums.sort()

    val sb = StringBuilder()

    if (nums.isEmpty()) return ""

    var i = 0
    var left = nums[0]
    var current: Int
    while (i < nums.size - 1) {
        current = nums[i]
        val diff = nums[i + 1] - current
        if (diff == 1) {
            i++
            continue
        }

        if (left == current) {
            sb.append("$left,")
        } else {
            sb.append("$left-$current,")
        }

        left = nums[i + 1]

        i++
    }
    current = nums[nums.lastIndex]

    if (left == current) {
        sb.append("$left")
    } else {
        sb.append("$left-$current")
    }

    return sb.toString()
}

fun main(args: Array<String>) {
    val example1 = printBeautify(intArrayOf(1, 2, 3, 4, 5, 8, 9, 11))
    println(example1)
    val example2 = printBeautify(intArrayOf(11))
    println(example2)

    val similar = findSimilar(TreeNode('A').apply {
        left = TreeNode('B').apply {
            right = TreeNode('C')
        }
        right = TreeNode('C').apply {
            left = TreeNode('B')
        }
    })
    println("${similar?.first?.`val`} ${similar?.second?.`val`}")
}

class TreeNode(var `val`: Char) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun findSimilar(root: TreeNode): Pair<TreeNode, TreeNode>? {
    val memory = mutableMapOf<TreeNode, MutableSet<Char>>()
    fillMemory(root, memory)

    val searchMap = mutableMapOf<Set<Char>, TreeNode>()
    for (entry in memory) {
        val memorized = searchMap.get(entry.value)
        if (memorized != null) {
            return entry.key to memorized
        }
        searchMap[entry.value] = entry.key
    }

    return null
}

fun fillMemory(root: TreeNode?, memory: MutableMap<TreeNode, MutableSet<Char>>): Set<Char> {
    if (root == null) return emptySet()
    if (root.left == null && root.right == null) return setOf(root.`val`)

    val result = mutableSetOf<Char>()
    val left = root.left
    if (left != null) {
        result.addAll(fillMemory(left, memory))
    }
    val right = root.right
    if (right != null) {
        result.addAll(fillMemory(right, memory))
    }
    result.add(root.`val`)

    memory[root] = result

    return result
}