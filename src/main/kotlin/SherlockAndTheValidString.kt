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

// Complete the isValid function below.
fun isValid(s: String): String {
    val map = fillMap(s)

    val frequency = map[s[0]]
    val difference = countDifference(map.values.toList())
    //Если выпало так,что frequency самая встречаемая буква
    val result = map.values.filter { it != frequency }
    if (result.isEmpty())
        return "YES"
    else if (result.size == 1 && (result[0] == frequency!! + 1 || result[0] == 1)) {
        return "YES"
    } else if (frequency == 1 && difference == 1 && result.size == map.size - 1) {
        return "YES"
    }
    return "NO"
}

private fun countDifference(values: List<Int>): Int {
    val list = values.sorted()
    var difference = 0
    for (i in 0 until list.size - 1)
        if (values[i] != values[i + 1])
            difference++
    return difference
}

private fun fillMap(s: String): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    val list = s.toList()
    list.forEach {
        if (map.containsKey(it))
            map[it] = map[it]!! + 1
        else map[it] = 1
    }
    return map
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = isValid(s)

    println(result)
}
