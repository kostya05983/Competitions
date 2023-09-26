package leetCode.medium

class ReorderList {
    fun reorderList(head: ListNode?) {
        var size = 0
        var current = head

        val map = HashMap<Int, ListNode>()
        while (current != null) {
            map[size] = current
            size++
            current = current.next
        }

        var left = 0
        var right = size - 1

        current = null
        while (left <= right) {
            val leftNode = map[left]
            val rightNode = map[right]

            if (left == right) {
                leftNode?.next = null
                current?.next = leftNode
                break
            }

            rightNode?.next = null
            leftNode?.next = rightNode
            current?.next = leftNode

            current = rightNode

            left++
            right--
        }
    }
}

fun main(args: Array<String>) {
    val solution = ReorderList()
    val input = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    val example1 = solution.reorderList(input)
    println(input)
}