package stepik

import java.lang.StringBuilder
import java.util.*


/**
 * Node for huffman coding
 */
class Node(
    var left: Node? = null,
    var right: Node? = null,
    var char: Char? = null,
    var frequency: Int = 0
)

class HuffmanTree {
    lateinit var root: Node

    fun getCodes(): MutableMap<Char, String> {
        val map = mutableMapOf<Char, String>()
        if (root.left == null && root.right == null) {
            map.put(root.char!!, "0")
            return map
        }
        getCode(map, "", root)
        return map
    }

    private fun getCode(map: MutableMap<Char, String>, code: String, root: Node?) {
        if (root != null) {
            if (root.char != null) {
                map[root.char!!] = code
            }

            if (root.left != null) {
                getCode(map, code + "0", root.left!!)
            }

            if (root.right != null) {
                getCode(map, code + "1", root.right!!)
            }
        }
    }


}

/**
 * Build a priorityQueue by frequencies
 */
fun buildPriorityQueue(sequence: String): PriorityQueue<Node> {
    val priorityQueue = PriorityQueue<Node>(kotlin.Comparator { o1, o2 ->
        return@Comparator o1.frequency.compareTo(o2.frequency)
    })

    val set = sequence.toSet()
    for (char in set) {
        var count = 0
        for (i in 0 until sequence.length) {
            if (char == sequence[i])
                count++
        }
        priorityQueue.add(Node(null, null, char, count))
    }

    return priorityQueue
}

/**
 * Build a huffman tree
 */
fun buildTree(queue: PriorityQueue<Node>): HuffmanTree {
    val huffmanTree = HuffmanTree()
    while (queue.size > 1) {
        val first = queue.poll()
        val second = queue.poll()

        val new = Node(first, second, null, first.frequency + second.frequency)


        queue.add(new)
    }
    huffmanTree.root = queue.poll()

    return huffmanTree
}

/**
 * Encode sequence to huffman codding
 */
fun encode(codes: MutableMap<Char, String>, sequence: String): String {
    val sb = StringBuilder()
    for (char in sequence) {
        sb.append(codes[char])
    }
    return sb.toString()
}


fun main() {
    val scanner = Scanner(System.`in`)
    val sequence = scanner.nextLine()

    val queue = buildPriorityQueue(sequence)
    val size = queue.size
    val tree = buildTree(queue)
    val codes = tree.getCodes()
    val encodingString = encode(codes, sequence)


    println("${size} ${encodingString.length}")
    for ((key, value) in codes) {
        println("$key: $value")
    }
    println(encodingString)
}