package secret

import java.util.*

fun getFibonachi(n: Int): Long {
    val array = LongArray(n+1)
    array[0] = 0
    array[1] = 1

    for (i in 2 .. n) {
        array[i] = array[i - 1] + array[i - 2]
    }

    return array[n]
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextLine()

    println(getFibonachi(n.toInt()))
}