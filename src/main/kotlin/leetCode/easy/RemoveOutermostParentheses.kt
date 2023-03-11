package leetCode.easy

import java.lang.StringBuilder
import java.util.Stack

class RemoveOutermostParentheses {
    fun removeOuterParentheses(s: String): String {
        val stack = Stack<Char>()

        val result = StringBuilder()

        for (ch in s) {
            if (ch == '(') {
                stack.add(ch)
                if (stack.size != 1) {
                    result.append(ch)
                }
            }
            if (ch == ')') {
                if (stack.size != 1) {
                    result.append(ch)
                }
                stack.pop()
            }
        }

        return result.toString()
    }
}

fun main(args: Array<String>) {
    val solution = RemoveOutermostParentheses()
    val test1 = solution.removeOuterParentheses("(()())(())")
    require(test1 == "()()()")

    val test2 = solution.removeOuterParentheses("(()())(())(()(()))")
    require(test2 == "()()()()(())")

    val test3 = solution.removeOuterParentheses("()()")
    require(test3 == "")
}