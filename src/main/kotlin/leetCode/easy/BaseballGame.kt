package leetCode.easy

import java.util.LinkedList

class BaseballGame {
    fun calPoints(operations: Array<String>): Int {
        val stack = LinkedList<Int>()
        operations.forEach {
            when (it) {
                "C" -> {
                    stack.removeLast()
                }

                "D" -> {
                    stack.add(stack.last * 2)
                }

                "+" -> {
                    val previous = stack.last
                    val doublePrevious = stack[stack.size - 2]
                    stack.add(previous + doublePrevious)
                }

                else -> stack.add(it.toInt())
            }
        }

        return stack.sum()
    }
}

fun main(args: Array<String>) {
    val solution = BaseballGame()
    val test1 = solution.calPoints(arrayOf("5", "2", "C", "D", "+"))
    require(test1 == 30)

    val test2 = solution.calPoints(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+"))
    require(test2 == 27)

    val test3 = solution.calPoints(arrayOf("1", "C"))
    require(test3 == 0)
}