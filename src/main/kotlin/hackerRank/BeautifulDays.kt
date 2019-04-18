package hackerRank

import java.util.*

// Complete the hackerRank.beautifulDays function below.
fun beautifulDays(i: Int, j: Int, k: Int): Int {
    var result = 0
    for (l in i..j) {
        if ((l - getInvert(l)).rem(k) == 0) {
            result++
        }
    }
    return result
}

fun getInvert(value: Int) = value.toString().reversed().toInt()


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val ijk = scan.nextLine().split(" ")

    val i = ijk[0].trim().toInt()

    val j = ijk[1].trim().toInt()

    val k = ijk[2].trim().toInt()

    val result = beautifulDays(i, j, k)

    println(result)
}
