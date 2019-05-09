package stepik.dynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private fun solve() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val line = br.readLine()
    var currentIndex = -1
    val array = IntArray(n)
    for (i in 0 until n - 1) {
        val index = currentIndex + 1
        currentIndex = line.indexOf(' ', index)

        array[i] = line.substring(index, currentIndex).toInt()
    }
    array[array.size - 1] = line.substring(currentIndex + 1).toInt()

    val res = countSubSequenceSlow(array)
    println(res)
}

private fun countSubSequenceSlow(array: IntArray): String {
    val dArray = IntArray(array.size)
    val prevArray = IntArray(array.size)
    for (i in 0 until dArray.size) {
        dArray[i] = 1
        prevArray[i] = -1
        for (j in 0 until i) {
            if (array[j] >= array[i] && dArray[j] + 1 > dArray[i]) {
                dArray[i] = dArray[j] + 1
                prevArray[i] = j
            }
        }
    }
    val sb = StringBuilder()
    val max = dArray.max()!!
    sb.appendln(max)

    var pos = dArray.indexOf(max)
    val path = Vector<Int>()
    while (pos != -1) {
        path.add(pos + 1)
        pos = prevArray[pos]
    }
    path.reverse()

    sb.append(path.joinToString(" "))

    return sb.toString()
}


fun upperBound(array: IntArray, element: Int): Int {
    var low = 0
    var high = array.size
    while (low < high) {
        val mid = (low + high) / 2
        if (element >= array[mid]) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}

private fun countSubSequence(array: IntArray): String {
    val dArray = IntArray(array.size) { Int.MAX_VALUE }
    val pos = IntArray(array.size)
    val prev = IntArray(array.size)
    var length = 0

    if (array.size == 1) {
        val sb = StringBuilder()
        sb.appendln(1)
        sb.append(1)
        return sb.toString()
    }

    pos[0] = -1
    dArray[0] = Int.MIN_VALUE
    for (i in array.size - 1 downTo 0) {
        var j = upperBound(dArray, array[i])
        if (j == array.size) j -= 1
        if (dArray[j - 1] <= array[i] && array[i] <= dArray[j]) {
            dArray[j] = array[i]
            pos[j] = i
            prev[i] = pos[j - 1]
            length = Math.max(length, j)
        }
    }

    val sb = StringBuilder()
    sb.appendln(length)

    val vector = Vector<Int>()
    var p = pos[length]
    while (p != -1) {
        vector.add(p + 1)
        p = prev[p]
    }
    sb.append(vector.joinToString(" "))

    return sb.toString()
}

private fun generate() {
    val random = Random()
    val n = 2
//    val l = intArrayOf()


    val start = System.currentTimeMillis()
    for (i in 0 until 100) {
        val l = IntArray(n) { random.nextInt() }
        val s = countSubSequence(l)
    }
    println((System.currentTimeMillis() - start).toDouble() / 100)
}


fun main() {
    solve()
//    generate()
}