package leetCode.medium

class SplitLinkedListInParts {


    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        if (head == null) return Array(k) { null }
        var size = 0

        var current: ListNode? = head
        while (current != null) {
            size++
            current = current.next
        }

        current = head

        val result = Array<ListNode?>(k) { null }

        val amountOfParts = minOf(k, size)
        var remaining = size.rem(amountOfParts)
        val partSize = size / amountOfParts

        var startPoint: ListNode? = head
        var arrayIndex = 0
        var localI = 1
        while (current != null) {
            if (remaining <= 0 && localI == partSize || remaining > 0 && localI == partSize + 1) {
                remaining--

                result[arrayIndex] = startPoint
                startPoint = current.next

                current.next = null
                current = startPoint
                arrayIndex++
                localI = 1
                continue
            }

            current = current.next
            localI++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = SplitLinkedListInParts()
    val example1 = solution.splitListToParts(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3)
        }
    }, 5)
    println(example1)
//
    val example2 = solution.splitListToParts(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6).apply {
                            next = ListNode(7).apply {
                                next = ListNode(8).apply {
                                    next = ListNode(9).apply {
                                        next = ListNode(10)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }, 3)
    println(example2)

    val example3 = solution.splitListToParts(ListNode(0).apply {
        next = ListNode(1).apply {
            next = ListNode(2)
        }
    }, 2)
    println(example3)

    val example4 = solution.splitListToParts(ListNode(0).apply {
        next = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4)
                }
            }
        }
    }, 3)
    println(example4)
}