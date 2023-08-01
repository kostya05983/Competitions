package leetCode.medium

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

class CloneGraph {
    private val memory = mutableMapOf<Int, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val memorized = memory[node.`val`]
        if (memorized != null) return memorized

        val newNode = Node(node.`val`)
        memory[node.`val`] = newNode

        val result = ArrayList<Node?>()

        for (neighbour in node.neighbors) {
            result.add(cloneGraph(neighbour))
        }

        return newNode.apply {
            neighbors = result
        }
    }
}

fun main(args: Array<String>) {
//    val solution = CloneGraph()
//    solution.cloneGraph(
//        Node().apply {
//            neighbors = listOf()
//        }
//    )
}