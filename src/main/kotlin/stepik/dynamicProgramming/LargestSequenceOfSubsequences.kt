package stepik.dynamicProgramming

import java.util.*

private fun countSubSequences(array: IntArray): Int {
    val dArray = IntArray(array.size)
    for (i in 0 until dArray.size) {
        dArray[i] = 1
        for (j in 0 until i) {
            if (array[i].rem(array[j]) == 0 && dArray[j] + 1 > dArray[i]) {
                dArray[i] = dArray[j] + 1
            }
        }
    }
    return dArray.max()!!
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine()

    val array = scanner.nextLine().split(" ").map {
        it.toInt()
    }.toIntArray()
    val res = countSubSequences(array)
    println(res)
}