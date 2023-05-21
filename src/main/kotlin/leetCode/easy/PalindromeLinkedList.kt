package leetCode.easy

import leetCode.medium.ListNode

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
        if (head.next == null) return true

        val firstHalf = findTheMiddle(head)
        val secondHalf = reverseList(firstHalf.next!!)

        var left: ListNode? = head
        var right: ListNode? = secondHalf
        var result = true
        while (result && right != null) {
            if (left?.`val` != right.`val`) {
                result = false
            }
            left = left?.next
            right = right.next
        }

        firstHalf.next = reverseList(secondHalf)

        return result
    }

    private fun reverseList(head: ListNode): ListNode {
        var prev: ListNode? = null
        var current: ListNode? = head
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev!!
    }

    private fun findTheMiddle(head: ListNode): ListNode {
        var fast: ListNode? = head
        var slow: ListNode? = head

        while (fast?.next != null && fast.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        return slow!!
    }
}

fun main(args: Array<String>) {
    println(PalindromeLinkedList().isPalindrome(ListNode(1, ListNode(2, ListNode(2, ListNode(1))))))
    println(PalindromeLinkedList().isPalindrome(ListNode(1, ListNode(2))))
    println(PalindromeLinkedList().isPalindrome(ListNode(1, ListNode(0, ListNode(1)))))
    println(PalindromeLinkedList().isPalindrome(ListNode(1, ListNode(0, ListNode(0)))))
}