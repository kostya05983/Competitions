package leetCode.medium

import java.util.*


class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()

        for (token in tokens) {
            when (token) {
                "+" -> {
                    stack.push(stack.pop() + stack.pop())
                }
                "-" -> {
                    val right = stack.pop()
                    val left = stack.pop()

                    stack.push(left - right)
                }
                "/" -> {
                    val right = stack.pop()
                    val left = stack.pop()

                    stack.push(left / right)
                }
                "*" -> {
                    val left = stack.pop()
                    val right = stack.pop()

                    stack.push(left * right)
                }
                else -> {
                    stack.push(token.toInt())
                }
            }
        }

        return stack.peek()
    }
}

fun main(args: Array<String>) {
    val solution = EvaluateReversePolishNotation()
    println(solution.evalRPN(arrayOf("2", "1", "+", "3", "*")))
    println(solution.evalRPN(arrayOf("4", "13", "5", "/", "+")))
    println(solution.evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
}