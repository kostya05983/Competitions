package differentAlgorithm

import java.util.*

private fun findForEach(inArray: LongArray, searchNumbers: LongArray): IntArray {
    val result = IntArray(searchNumbers.size)

    for (i in 0 until searchNumbers.size) {
        result[i] = binarySearch(inArray, searchNumbers[i])
    }
    return result
}

private fun binarySearch(array: LongArray, number: Long): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val m = (left + right) / 2
        when {
            array[m] == number -> return m + 1
            array[m] > number -> right = m - 1
            else -> left = m + 1
        }
    }
    return -1
}


fun main() {
    val scanner = Scanner(System.`in`)
    val firstLine = scanner.nextLine().split(" ")

    val size = firstLine[0].toInt()
    val array = LongArray(size)

    for (i in 0 until size) array[i] = firstLine[1 + i].toLong()

    val secondLine = scanner.nextLine().split(" ")

    val secondSize = secondLine[0].toInt()
    val secondArray = LongArray(secondSize)

    for (i in 0 until secondSize) secondArray[i] = secondLine[i + 1].toLong()

    val result = findForEach(array, secondArray)

    for (element in result) {
        print("$element ")
    }
}