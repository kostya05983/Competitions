package leetCode.easy

import java.util.Stack

class SumOfDigitsAfterStringConvert {


    fun getLucky(s: String, k: Int): Int {
        val numberStack = Stack<Int>()
        for (ch in s) {
            numberStack.add((ch.toInt() - 96))
        }

        if (k == 0) return numberStack.joinToString("").toInt()

        var n = 0

        var result = 0
        while (n != k) {
            result = 0

            while (numberStack.isNotEmpty()) {
                var intRepresentation = numberStack.pop()
                while (intRepresentation != 0) {
                    result += intRepresentation.rem(10)
                    intRepresentation /= 10
                }
            }

            if (result < 10) {
                return result
            }

            numberStack.add(result)
            n++
        }

        return result
    }
}

fun main(args: Array<String>) {
//    println(SumOfDigitsAfterStringConvert().getLucky("a", 0))
//    println(SumOfDigitsAfterStringConvert().getLucky("iiii", 1))
//    println(SumOfDigitsAfterStringConvert().getLucky("leetcode", 2))
//    println(SumOfDigitsAfterStringConvert().getLucky("zbax", 2))
    println(SumOfDigitsAfterStringConvert().getLucky("iaozzbyqzwbpurzze", 2))
}