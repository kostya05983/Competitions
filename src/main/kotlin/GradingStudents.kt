import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

/*
 * Complete the gradingStudents function below.
 */
fun gradingStudents(grades: Array<Int>): Array<Int> {
    /*
     * Write your code here.
     */
    return grades
        .map { if (it>=38&&it.rem(5) >= 3) it + (5 - it.rem(5)) else it }.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val grades = Array<Int>(n, { 0 })
    for (gradesItr in 0 until n) {
        val gradesItem = scan.nextLine().trim().toInt()
        grades[gradesItr] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}
