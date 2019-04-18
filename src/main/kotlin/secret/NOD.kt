package secret

import java.util.*

fun findNod(n: Long, m: Long): Long {
    var remN = n
    var remM = m
    while (remN != 0L && remM != 0L) {
        if (remN > remM) remN = remN.rem(remM)
        else remM = remM.rem(remN)
    }
    return if (remM == 0L) remN else remM
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val split = scanner.nextLine().split(" ")

    println(findNod(split[0].toLong(), split[1].toLong()))
}