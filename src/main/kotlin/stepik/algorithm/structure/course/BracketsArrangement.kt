package stepik.algorithm.structure.course

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

/**
 * @author kostya05983
 */
class BracketsArrangement {

    fun solve(s: String): String {
        val stack = Stack<Char>()
        for (i in 0 until s.length) {
            when (s[i]) {
                '(', '[', '{' -> {
                    stack.push(s[i])
                }
                else -> {
                    if (stack.empty()) {
                        return (i + 1).toString()
                    }
                    val p = stack.peek()
                    if (p != null) {
                        when (p) {
                            '(' -> {
                                if (s[i] != ')') {
                                    return (i + 1).toString()
                                }
                                stack.pop()
                            }
                            '[' -> {
                                if (s[i] != ']') {
                                    return (i + 1).toString()
                                }
                                stack.pop()
                            }
                            '{' -> {
                                if (s[i] != '}') {
                                    return (i + 1).toString()
                                }
                                stack.pop()
                            }
                            else -> {
                                return (i + 1).toString()
                            }
                        }
                    } else {
                        return (i + 1).toString()
                    }
                }
            }
        }
        return "Success"
    }

    fun main(args: Array<String>) {
        // put your code here
        val bf = BufferedReader(InputStreamReader(System.`in`))
        val line = bf.readLine()
        solve(line)
    }
}


fun solve(s: String): String {
    val stack = Stack<Char>()
    for (i in 0 until s.length) {
        when (s[i]) {
            '(', '[', '{' -> {
                stack.push(s[i])
            }
            else -> {
                if (stack.empty()) {
                    return (i + 1).toString()
                }
                val p = stack.peek()
                if (p != null) {
                    when (p) {
                        '(' -> {
                            if (s[i] != ')') {
                                return (i + 1).toString()
                            }
                            stack.pop()
                        }
                        '[' -> {
                            if (s[i] != ']') {
                                return (i + 1).toString()
                            }
                            stack.pop()
                        }
                        '{' -> {
                            if (s[i] != '}') {
                                return (i + 1).toString()
                            }
                            stack.pop()
                        }
                        else -> {
                            return (i + 1).toString()
                        }
                    }
                } else {
                    return (i + 1).toString()
                }
            }
        }
    }
    return "Success"
}


fun main(args: Array<String>) {
    // put your code here
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val line = bf.readLine()
    println(solve(line))
}