package stepik

import java.lang.StringBuilder
import java.util.*


/**
 * Node for huffman coding
 */
class Node {
    var left: Node? = null
    var right: Node? = null
    var char: Char? = null
    var frequency: Int = 0
}

class HuffmanTree {
    var root: Node? = null

    fun add(newNode: Node) {
        val huffmanCode = StringBuilder()

    }

    fun getASMap(): Map<Char, String> {
        if (root == null) {
            return mutableMapOf()
        }

        val stack = Stack<Node>()
        stack.push(root)
        val map = mutableMapOf<Char, String>()

        while (!stack.empty()) {
            val current = stack.pop()
//            map[current.char!!] = current.code
            if (current.left != null) {
                stack.push(current.left)
            }
            if (current.right != null) {
                stack.push(current.right)
            }
        }
        return map
    }
}

/**
 * Build a priorityQueue by frequencies
 */
fun buildPriorityQueue(sequence: String): PriorityQueue<Char> {
    val priorityQueue = PriorityQueue<Char>()
    val map = mutableMapOf<Int, Char>()

    for (char in sequence) {
        var count = 0
        for (i in 0 until sequence.length) {
            if (char == sequence[i])
                count++
        }
        map[count] = char
    }
    val toSortedMap = map.toSortedMap()
    for ((_, value) in toSortedMap) {
        priorityQueue.add(value)
    }
    return priorityQueue
}


fun main() {
    val scanner = Scanner(System.`in`)
    val sequence = scanner.nextLine()

    val queue = buildPriorityQueue(sequence)
    println(queue)
}