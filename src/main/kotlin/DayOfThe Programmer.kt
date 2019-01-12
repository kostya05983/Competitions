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

// Complete the dayOfProgrammer function below.
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
