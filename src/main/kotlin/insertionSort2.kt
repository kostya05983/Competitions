import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the insertionSort2 function below.
fun insertionSort2(n: Int, arr: Array<Int>): Unit {
    for (i in 0 until n) {

        for (j in i downTo 1)
            if (arr[j - 1] > arr[j])
                arr.swap(j)
        if(i!=0) {
            printarr(arr)
        }
    }
}

fun <T> Array<T>.swap(j: Int) {
    val temp = this[j]
    this[j] = this[j - 1]
    this[j - 1] = temp
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    insertionSort2(n, arr)
}