package leetCode.easy

import leetCode.ListNode

class DeleteDuplicates {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var current = head
        while (current != null) {
            val next = current.next
            if (next?.`val` == current.`val`) {
                current.next = next.next
            } else {
                current = current.next
            }
        }

        return head
    }
}

fun main(args: Array<String>) {

}