package hackerRank

import java.io.*
import java.util.*
import java.util.stream.*
import kotlin.Comparator
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Complete the hackerRank.bigSorting function below.
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
        BufferedReader(FileReader("/home/kostya05983/Projects/competitions/src/hackerRank.main/resources/numbers.txt"))
    val arr = bufferedReader.lines().collect(Collectors.toList()).toTypedArray()
    val startTime = System.currentTimeMillis()
    bigSorting(arr)
    println(System.currentTimeMillis() - startTime)
}


fun main(args: Array<String>) {
//    hackerRank.runFromFile()
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
