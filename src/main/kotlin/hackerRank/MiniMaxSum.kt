package hackerRank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Complete the hackerRank.miniMaxSum function below.
fun miniMaxSum(arr: Array<Int>): Unit {
    arr.sort()
    var min = 0L
    var max = 0L
    for (i in 0 until 4)
        min += arr[i].toLong()
    for (i in 4 downTo 1)
        max += arr[i].toLong()

    println("$min $max")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}