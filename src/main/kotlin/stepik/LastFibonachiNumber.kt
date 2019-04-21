package stepik

import java.util.*

fun getLastNumber(n: Int): Int {
    val array = IntArray(n + 1)
    array[0] = 0
    array[1] = 1

    for (i in 2..n) {
        array[i] = (array[i - 1] + array[i - 2]).rem(10)
    }

    return array[n]
}

fun main() {
    val s = Scanner(System.`in`)
    val nextLine = s.nextLine()

    println(getLastNumber(nextLine.toInt()))
}