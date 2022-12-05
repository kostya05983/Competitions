package leetCode


class MergeTwoSortedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }

        var left = list1
        var right = list2
        val head: ListNode = if (left.`val` < right.`val`) {
            val leftVal = left.`val`
            left = left.next
            ListNode(leftVal)
        } else {
            val rightVal = right.`val`
            right = right.next
            ListNode(rightVal)
        }
        var current: ListNode = head
        while (left != null || right != null) {
            val leftVal = left?.`val`
            val rightVal = right?.`val`

            if (leftVal != null && rightVal != null && leftVal  <= rightVal) {
                left = left?.next
                current.next = ListNode(leftVal)
            } else if (leftVal != null && rightVal != null && rightVal < leftVal) {
                right = right?.next
                current.next = ListNode(rightVal)
            } else if (leftVal != null && rightVal == null) {
                left = left?.next
                current.next = ListNode(leftVal)
            } else if (rightVal != null && leftVal == null) {
                right = right?.next
                current.next = ListNode(rightVal)
            }
            current = current.next!!
        }

        return head
    }
}

fun main(args: Array<String>) {
    println(
        MergeTwoSortedList().mergeTwoLists(
            ListNode(1, ListNode(2, ListNode(4))),
            ListNode(1, ListNode(3, ListNode(4)))
        )
    )
    println(MergeTwoSortedList().mergeTwoLists(null, ListNode(0)))
}