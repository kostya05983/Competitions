package leetCode.medium

import java.lang.StringBuilder

class PrintWordsVertically {
    fun printVertically(s: String): List<String> {
        val splitted = s.split(" ")

        val maxLength = splitted.maxBy { it.length }.length

        val result = Array(maxLength) { StringBuilder() }
        var left = 0
        while (left < maxLength) {
            var lastSeen = 0
            for (i in splitted.indices) {
                val ch = splitted[i].getOrElse(left) { ' ' }
                if (ch != ' ') lastSeen = i
                result[left].append(ch)
            }
            result[left].setLength(lastSeen + 1)
            left++
        }

        return result.map { it.toString() }
    }
}

fun main(args: Array<String>) {
    val solution = PrintWordsVertically()
    println(solution.printVertically("HOW ARE YOU"))
    println(solution.printVertically("TO BE OR NOT TO BE"))
}