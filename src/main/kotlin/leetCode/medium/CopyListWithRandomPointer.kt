package leetCode.medium

class CopyListWithRandomPointer {
    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        val newHead = Node(node.`val`)

        var current: Node? = node.next
        val originalToCopy = HashMap<Node, Node>()
        originalToCopy[node] = newHead

        while (current != null) {
            originalToCopy[current] = Node(current.`val`)

            current = current.next
        }

        current = node

        while (current != null) {
            originalToCopy[current]?.next = originalToCopy[current.next]
            originalToCopy[current]?.random = originalToCopy[current.random]

            current = current.next
        }

        return newHead
    }
}

fun main(args: Array<String>) {
    val solution = CopyListWithRandomPointer()
    solution.copyRandomList(CopyListWithRandomPointer.Node(7).apply {
        val zero = this
        random = null
        next = CopyListWithRandomPointer.Node(13).apply {
            random = zero
            next = null
        }
    })
}