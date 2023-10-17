package leetCode.medium

class DeleteNodeLinkedList {
    fun deleteNode(node: ListNode?) {
        var current = node
        while (current != null) {
            val next = current.next
            if (next != null) {
                current.`val` = next.`val`
            }
            if (next?.next == null) {
                current.next = null
                break
            }
            current = next
        }
    }
}

fun main(args: Array<String>) {
}