package aoe2022

import java.io.File
import java.lang.StringBuilder
import java.util.*

class Day5 {

    fun solve(): String {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_5.txt").readLines()
        val stackList = Array<Stack<Char>>(9) { Stack() }
        for (i in 0 until 9) {
            val line = input[i]
            var count = 0
            for (j in line.indices) {
                val ch = line[j]
                if (j.rem(4) == 0 && j != 0) count++
                if (ch == '[' || ch == ']' || ch == ' ') {
                    continue
                }
                if (ch.isLetter()) {
                    val stack = stackList[count]
                    stack.add(ch)
                    stackList[count] = stack
                }
            }
        }
        for (stack in stackList) {
            stack.reverse()
        }

        for (i in 10 until input.size) {
            val line = input[i]
            val splitted = line.split(" ")
            val size = splitted[1].toInt()
            val from = splitted[3].toInt() - 1
            val to = splitted[5].toInt() - 1

            val fromStack = stackList[from]
            val toStack = stackList[to]

            for (j in 0 until size) {
                val el = fromStack.pop()
                toStack.add(el)
            }
        }

        val result = StringBuilder()
        for (el in stackList) {
            val stackElement = el.pop()
            result.append(stackElement)
        }

        return result.toString()
    }

    fun solve2(): String {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_5.txt").readLines()
        val stackList = Array<Stack<Char>>(9) { Stack() }
        for (i in 0 until 9) {
            val line = input[i]
            var count = 0
            for (j in line.indices) {
                val ch = line[j]
                if (j.rem(4) == 0 && j != 0) count++
                if (ch == '[' || ch == ']' || ch == ' ') {
                    continue
                }
                if (ch.isLetter()) {
                    val stack = stackList[count]
                    stack.add(ch)
                    stackList[count] = stack
                }
            }
        }
        for (stack in stackList) {
            stack.reverse()
        }

        for (i in 10 until input.size) {
            val line = input[i]
            val splitted = line.split(" ")
            val size = splitted[1].toInt()
            val from = splitted[3].toInt() - 1
            val to = splitted[5].toInt() - 1

            val fromStack = stackList[from]
            val toStack = stackList[to]

            val temp = mutableListOf<Char>()
            for (j in 0 until size) {
                val el = fromStack.pop()
                temp.add(el)
            }

            var k = temp.size - 1
            while (k >= 0) {
                val el = temp[k]
                toStack.add(el)
                k--
            }
        }

        val result = StringBuilder()
        for (el in stackList) {
            val stackElement = el.pop()
            result.append(stackElement)
        }

        return result.toString()
    }

}

fun main(args: Array<String>) {
    println(Day5().solve2())
}