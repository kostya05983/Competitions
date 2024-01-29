package leetCode.easy

import java.util.Stack

class ImplementQueueUsingStacks {
    private val firstStack = Stack<Int>()
    private val secondStack = Stack<Int>()

    fun push(x: Int) {
        firstStack.push(x)
    }

    fun pop(): Int {
        refillStack()

        return secondStack.pop()
    }

    fun peek(): Int {
        refillStack()

        return secondStack.peek()
    }

    fun empty(): Boolean {
        return secondStack.isEmpty() && firstStack.isEmpty()
    }

    private fun refillStack() {
        if (secondStack.isNotEmpty()) return
        while (firstStack.isNotEmpty()) {
            secondStack.add(firstStack.pop())
        }
    }
}

fun main(args: Array<String>) {
    val solution = ImplementQueueUsingStacks()
    solution.push(1)
    solution.push(2)
    solution.push(3)
    solution.push(4)
    println(solution.pop())
    solution.push(5)
    println(solution.pop())
    println(solution.pop())
    println(solution.pop())
    println(solution.pop())
}