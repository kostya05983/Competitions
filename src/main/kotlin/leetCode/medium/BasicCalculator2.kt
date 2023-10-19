package leetCode.medium

import java.lang.StringBuilder
import java.util.StringJoiner

class BasicCalculator2 {
    fun calculate(s: String): Int {
        var result = 0

        val splited = split(s)

        var localResult = 0
        var lastSymbol = '+'
        var i = 0

        while (i < splited.size) {
            val part = splited[i]
            when {
                part.toIntOrNull() != null -> {
                    localResult += part.toInt()
                }

                part == "+" -> {
                    result += if (lastSymbol == '+') {
                        localResult
                    } else {
                        -localResult
                    }

                    localResult = 0
                    lastSymbol = '+'
                }

                part == "-" -> {
                    result += if (lastSymbol == '+') {
                        localResult
                    } else {
                        -localResult
                    }
                    localResult = 0
                    lastSymbol = '-'
                }

                part == "/" -> {
                    localResult /= splited[i + 1].toInt()
                    i++

                }

                part == "*" -> {
                    localResult *= splited[i + 1].toInt()
                    i++
                }
            }
            i++
        }
        result += if (lastSymbol == '+') {
            localResult
        } else {
            -localResult
        }

        return result
    }

    fun split(s: String): List<String> {
        val before = StringBuilder()

        val result = mutableListOf<String>()
        for (ch in s) {
            if (ch == ' ') continue
            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                result.add(before.toString())
                before.clear()
                result.add(ch.toString())
                continue
            }
            before.append(ch)
        }
        result.add(before.toString())

        return result
    }
}

fun main(args: Array<String>) {
    val solution = BasicCalculator2()
    println(solution.calculate("3+2*2"))
    println(solution.calculate("3/2"))
    println(solution.calculate("3+5/2"))
    println(solution.calculate("3+2*2*2*2*2"))
    println(solution.calculate("3+2*2*2*2*2/2/2/2/2/2"))
    println(solution.calculate("3/1+5+10/2+12/2+4*2-12/3-6/2"))
}