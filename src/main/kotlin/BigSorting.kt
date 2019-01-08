import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.Comparator
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the bigSorting function below.
fun bigSorting(unsorted: Array<String>): Array<String> {
    val compareBigStrings = CompareBigStrings()
    Arrays.parallelSort(unsorted, compareBigStrings)
    return unsorted
}

class CompareBigStrings : Comparator<String> {
    override fun compare(a: String, b: String): Int {
        if (a.length == b.length)
            return a.compareTo(b)
        return a.length - b.length
    }
}

private fun runFromFile() {
    val bufferedReader =
        BufferedReader(FileReader("/home/kostya05983/Projects/competitions/src/main/resources/numbers.txt"))
    val arr = bufferedReader.lines().collect(Collectors.toList()).toTypedArray()
    val startTime = System.currentTimeMillis()
    bigSorting(arr)
    println(System.currentTimeMillis() - startTime)
}


fun main(args: Array<String>) {
//    runFromFile()
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val unsorted = Array<String>(n, { "" })
    for (i in 0 until n) {
        val unsortedItem = scan.nextLine()
        unsorted[i] = unsortedItem
    }

    val result = bigSorting(unsorted)
    println(result.joinToString("\n"))
}
