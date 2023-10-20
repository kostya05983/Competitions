package leetCode.medium

import java.util.LinkedList
import java.util.Stack

class NestedInteger {
    private val memory = mutableListOf<NestedInteger>()
    private var singleInteger = -1
    private var isInteger: Boolean = false

    // Constructor initializes an empty nested list.
    constructor() {
        isInteger = false
    }

    // Constructor initializes a single integer.
    constructor(value: Int) {
        singleInteger = value
        isInteger = true
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean {
        return isInteger
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? {
        return singleInteger
    }

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {
        singleInteger = value
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {
        memory.add(ni)
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger> {
        return memory
    }
}

class FlattenNestedListIterator(
    nestedList: List<NestedInteger>
) {
    private var stack = LinkedList<NestedInteger>(nestedList)

    fun next(): Int {
        return stack.pop().getInteger()!!
    }

    fun hasNext(): Boolean {
        while (stack.isNotEmpty() && !stack.peek().isInteger()) {
            val popped = stack.pop().getList()
            for (i in popped.size - 1 downTo 0) {
                stack.addFirst(popped[i])
            }
        }

        return stack.isNotEmpty()
    }
}

fun main(args: Array<String>) {
    val nestedList = mutableListOf(NestedInteger(1), NestedInteger().apply {
        add(NestedInteger(4))
        add(NestedInteger().apply {
            add(NestedInteger(6))
        })

    })

    val solution = FlattenNestedListIterator(nestedList)

    val result = mutableListOf<Int>()
    while (solution.hasNext()) {
        result.add(solution.next())
    }
    println(result)
}