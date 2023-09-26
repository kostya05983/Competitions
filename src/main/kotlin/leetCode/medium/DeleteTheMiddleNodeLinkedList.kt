package leetCode.medium

class DeleteTheMiddleNodeLinkedList {
    fun deleteMiddle(head: ListNode?): ListNode? {
        var size = 0
        var current = head

        val map = mutableMapOf<Int, ListNode>()
        while (current != null) {
            map[size] = current
            size++
            current = current.next
        }

        val middleIndex = size / 2

        val before = map[middleIndex - 1]
        val after = map[middleIndex + 1]
        before?.next = after


        return if (before == null) {
            after
        } else {
            head
        }
    }
}

fun main(args: Array<String>) {
    val solution = DeleteTheMiddleNodeLinkedList()
    val example1 = solution.deleteMiddle(ListNode(2).apply {
        next = ListNode(1)
    })
    println(example1)
}