package hackerRank

import kotlin.io.*
import kotlin.text.*

// Complete the hackerRank.dayOfProgrammer function below.
fun dayOfProgrammer(year: Int): String {
    return if (year == 1918)
        return "26.09.1918" else
        if (year < 1917) {
            if (year.rem(4) == 0)
                "12.09.$year"
            else "13.09.$year"

        } else {
            return if (year.rem(4) != 0) "13.09.$year"
            else {
                when {
                    year.rem(100) != 0 -> "12.09.$year"
                    year.rem(400) != 0 -> "13.09.$year"
                    else -> "12.09.$year"
                }
            }
        }

}

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()

    val result = dayOfProgrammer(year)

    println(result)
}
