package stepik

import java.util.*
import kotlin.collections.ArrayList


fun calc(n: Long, m: Int): Int {
    val pizanno = findPizano(n, m)

    return pizanno[n.rem(pizanno.size-2).toInt()]
}

fun findPizano(n: Long, m: Int): ArrayList<Int> {
    val pizanno = ArrayList<Int>()
    pizanno.add(0)

    if (m == 1) return pizanno

    pizanno.add(1)

    var n0 = 0
    var n1 = 1

    for (i in 2..m * 6) {
        val newn1 = (n0 + n1) % m
        val new0 = n1
        n1 = newn1
        n0 = new0

        pizanno.add(n1 % m)

        if (pizanno[pizanno.size - 1] == 1 && pizanno[pizanno.size - 2] == 0)
            break
    }

    return pizanno
}

fun main() {
    val scanner = Scanner(System.`in`)
    val nextLine = scanner.nextLine()
    val split = nextLine.split(" ")

    println(calc(split[0].toLong(), split[1].toInt()))
}