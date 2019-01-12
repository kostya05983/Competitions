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

// Complete the divisibleSumPairs function below.
fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    var amount = 0;
    for (i in 0 until ar.size) {
        for (j in i+1 until ar.size) {
            if ((ar[i] + ar[j]).rem(k) == 0)
                amount++
        }
    }
    return amount
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = divisibleSumPairs(n, k, ar)

    println(result)
}
