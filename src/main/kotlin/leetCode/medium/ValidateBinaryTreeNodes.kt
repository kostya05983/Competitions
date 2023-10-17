package leetCode.medium

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class ValidateBinaryTreeNodes {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val visited = mutableMapOf<Int, Int>()
        val parentMap = mutableMapOf<Int, MutableSet<Int>>()

        for (i in 0 until n) {
            visited[i] = visited.getOrDefault(i, 0)
            val left = leftChild[i]
            val right = rightChild[i]

            if (left in parentMap.getOrDefault(i, setOf())) {
                return false
            }
            if (right in parentMap.getOrDefault(i, setOf())) {
                return false
            }

            if (left != -1) {
                visited[left] = visited.getOrDefault(left, 0) + 1
                parentMap[left] = parentMap.getOrDefault(left, mutableSetOf()).also {
                    val parent = parentMap.getOrDefault(i, mutableSetOf(i))
                    it.addAll(parent)
                }
            }
            if (right != -1) {
                visited[right] = visited.getOrDefault(right, 0) + 1
                parentMap[right] = parentMap.getOrDefault(right, mutableSetOf()).also {
                    val parent = parentMap.getOrDefault(i, mutableSetOf(i))
                    it.addAll(parent)
                }
            }
        }

        var rootFound = false
        for (i in 0 until n) {
            val entry = visited[i] ?: continue
            if (entry > 1) return false
            if (entry == 0 && !rootFound) {
                rootFound = true
                continue
            }
            if (entry == 0) return false
        }


        return rootFound
    }
}

fun main(args: Array<String>) {
    val solution = ValidateBinaryTreeNodes()
    assertTrue(solution.validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, -1, -1, -1)))
    assertFalse(solution.validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, 3, -1, -1)))
    assertFalse(solution.validateBinaryTreeNodes(2, intArrayOf(1, 0), intArrayOf(-1, -1)))
    assertFalse(solution.validateBinaryTreeNodes(6, intArrayOf(1, -1, -1, 4, -1, -1), intArrayOf(2, -1, -1, 5, -1, -1)))
    assertTrue(solution.validateBinaryTreeNodes(4, intArrayOf(3, -1, 1, -1), intArrayOf(-1, -1, 0, -1)))
    assertFalse(solution.validateBinaryTreeNodes(3, intArrayOf(1, -1, -1), intArrayOf(-1, -1, 1)))
    assertFalse(solution.validateBinaryTreeNodes(4, intArrayOf(1, 0, 3, -1), intArrayOf(-1, -1, -1, -1)))
    assertFalse(solution.validateBinaryTreeNodes(4, intArrayOf(3, -1, -1, 0), intArrayOf(-1, -1, -1, -1)))
}