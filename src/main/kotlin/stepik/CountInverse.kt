package stepik

import java.util.*

private class MergeSort {

    fun mergeSort(array: LongArray, temp: LongArray, left: Int, right: Int): Long {
        var inverseCount = 0L
        val middle: Int
        if (right > left) {
            middle = (right + left) / 2

            inverseCount += mergeSort(array, temp, left, middle)
            inverseCount += mergeSort(array, temp, middle + 1, right)

            inverseCount += merge(array, temp, left, middle + 1, right)
        }
        return inverseCount
    }

    private fun merge(array: LongArray, temp: LongArray, left: Int, middle: Int, right: Int): Long {
        var i = left
        var j = middle
        var inversionCount = 0L
        var k = left

        while ((i <= middle - 1) && (j <= right)) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++]
            } else {
                temp[k++] = array[j++]
                inversionCount += (middle - i)
            }
        }

        while(i<=middle-1) temp[k++] = array[i++]

        while(j<=right) temp[k++] = array[j++]

        for(l in left..right) array[l] = temp[l]

        return inversionCount
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextLine().toInt()
    val array = LongArray(n)


    for (i in 0 until n) {
        array[i] = scanner.nextLong()
    }

    val mergeSort = MergeSort()
    val temp = LongArray(n)
    println(mergeSort.mergeSort(array, temp, 0, array.size - 1))
}