package leetCode.medium

class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val leftPartitionHead = ListNode(-1)
        var leftPartitionCurrent = leftPartitionHead

        val rightPartitionHead = ListNode(-1)
        var rightPartitionCurrent = rightPartitionHead

        var current = head
        while (current != null) {
            if (current.`val` < x) {
                leftPartitionCurrent.next = ListNode(current.`val`)
                leftPartitionCurrent = leftPartitionCurrent.next!!
            } else {
                rightPartitionCurrent.next = ListNode(current.`val`)
                rightPartitionCurrent = rightPartitionCurrent.next!!
            }
            current = current.next
        }

        leftPartitionCurrent.next = rightPartitionHead.next

        return leftPartitionHead.next
    }
}

fun main(args: Array<String>) {
    val solution = PartitionList()
    val example1 = solution.partition(ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(3).apply {
                next = ListNode(2).apply {
                    next = ListNode(5).apply {
                        next = ListNode(2)
                    }
                }
            }
        }
    }, 3)
    println(example1)

    val example2 = solution.partition(ListNode(2).apply {
        next = ListNode(1)
    }, 2)
    println(example2)

    val example3 = solution.partition(ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(3).apply {
                next = ListNode(0).apply {
                    next = ListNode(2).apply {
                        next = ListNode(5).apply {
                            next = ListNode(2)
                        }
                    }
                }
            }
        }
    }, 3)
    println(example3)

    val example4 = solution.partition(ListNode(1).apply {
        next = ListNode(1)
    }, 0)
    println(example4)

    val example5 = solution.partition(ListNode(3).apply {
        next = ListNode(1).apply {
            next = ListNode(2)
        }
    }, 3)
    println(example5)
}