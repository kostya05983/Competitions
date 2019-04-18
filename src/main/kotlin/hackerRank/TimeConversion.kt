package hackerRank

import java.util.*

/*
 * Complete the hackerRank.timeConversion function below.
 */
fun timeConversion(s: String): String {
    /*
     * Write your code here.
     */
    if (s.contains("PM") && s.substring(0, 2).contains("12")) {
        return s.substring(0, s.length - 2)
    }
    if (s.contains("AM") && s.substring(0, 2).contains("12")) {
        return s.substring(0, s.length - 2).replace(Regex("^[0-9][0-9]"), "00")
    }


    return if (s.contains("PM")) {
        val hour = (12 + s.substring(0, 2).toInt()).toString()
        s.substring(0, s.length - 2).replace(Regex("^[0-9][0-9]"), hour)
    } else {
        s.substring(0, s.length - 2)
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}
