package leetCode

import java.util.Stack

class ValidParentless {
    private companion object {
        val OPEN_BRACKETS = listOf('(', '{', '[')

    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (ch in s) {
            val peeked = takeIf { stack.isNotEmpty() }?.let {
                stack.peek()
            }
            when {
                ch in OPEN_BRACKETS -> {
                    stack.push(ch)
                }

                ch == ')' && peeked == '(' -> {
                    stack.pop()
                }

                ch == '}' && peeked == '{' -> {
                    stack.pop()
                }

                ch == ']' && peeked == '[' -> {
                    stack.pop()
                }

                else -> return false
            }
        }

        return stack.isEmpty()
    }
}

fun main(args: Array<String>) {
    println(ValidParentless().isValid("()"))
    println(ValidParentless().isValid("()[]{}"))
    println(ValidParentless().isValid("(]"))
}