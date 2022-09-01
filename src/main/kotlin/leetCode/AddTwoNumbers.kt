package leetCode

private data class ListNode(
    var `val`: Int,
    var next: ListNode?
) {
    constructor(remain: Int) : this(next = null, `val` = remain)
}

private class Solution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        val resultHead = ListNode(0, null)
        var currentLeft: ListNode? = l1
        var currentRight: ListNode? = l2
        var remain = 0
        var previous = currentLeft
        var current = resultHead
        while (currentLeft != null || currentRight != null) {
            val temp = (currentLeft?.`val` ?: 0) + (currentRight?.`val` ?: 0) + remain
            val newValue = temp.rem(10)
            remain = temp / 10
            current.`val` = newValue
            previous = current
            currentLeft = currentLeft?.next
            currentRight = currentRight?.next

            if (currentLeft != null || currentRight != null) {
                current.next = ListNode(0, null)
                current = current.next!!
            }
        }
        if (remain != 0) {
            val result = ListNode(remain)
            previous?.next = result
        }
        return resultHead
    }
}