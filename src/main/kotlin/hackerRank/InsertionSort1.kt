package hackerRank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Complete the hackerRank.insertionSort1 function below.
fun insertionSort1(n: Int, arr: Array<Int>): Unit {
    var current: Int? = null
    for (i in n - 1 downTo 1) {
        if (current != null && current < arr[i - 1]) {
            arr[i] = arr[i - 1]
            printarr(arr)
            if (i == 1) {
                arr[i - 1] = current
                printarr(arr)
            }

            continue
        } else if (current != null) {
            arr[i] = current
            printarr(arr)
            break
        }
        if (arr[i - 1] > arr[i]) {
            current = arr[i]
            arr[i] = arr[i - 1]
            printarr(arr)
        }
    }
}


fun printarr(arr: Array<Int>) {
    for (i in 0 until arr.size) {
        print("${arr[i]} ")
    }
    println()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    insertionSort1(n, arr)
}


fun lol(a: Int) {

    val list = listOf<Int>()

    for ( i in 0 until list.size) {
        println(list[i])
    }
}

class example(val firstArgument: Long, val secondArgument: Int) {




    init {

    }
}