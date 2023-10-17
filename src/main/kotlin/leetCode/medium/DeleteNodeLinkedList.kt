package leetCode.medium

class DeleteNodeLinkedList {
    fun deleteNode(node: ListNode?) {
        node?.`val` = node!!.next!!.`val`
        node.next = node.next?.next
    }
}

fun main(args: Array<String>) {
}