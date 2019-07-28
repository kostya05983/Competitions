package byteBybyte

import java.lang.IllegalArgumentException


private class SubArray {
    private val underlying: IntArray
    val start: Int
    val size: Int

    constructor(arr: IntArray) {
        underlying = arr
        start = 0
        size = arr.size
    }

    constructor(arr: IntArray, start: Int, size: Int) {
        this.underlying = arr
        this.start = start
        this.size = size
    }

    fun subArray(i: Int, j: Int): SubArray {
        return SubArray(underlying, start + i, j - i)
    }

    fun getMedian(): Double {
        if (size.rem(2) == 0) {
            return (underlying[start + size / 2 - 1] + underlying[start + size / 2]) / 2.0
        }
        return underlying[start + size / 2].toDouble()
    }

    fun getFirst(): Int {
        return underlying[start]
    }

    fun getLast(): Int {
        return underlying[start + size / 2]
    }
}

fun median(arr1: IntArray, arr2: IntArray): Double {
    if (arr1.isEmpty() || arr1.size != arr2.size) throw IllegalArgumentException()
    return median(SubArray(arr1), SubArray(arr2))
}

private fun median(arr1: SubArray, arr2: SubArray): Double {
    if (arr1.size == 1) {
        return (arr1.getFirst() + arr2.getFirst()) / 2.0
    }

    if (arr1.size == 2) {
        return (Math.max(arr1.getFirst(), arr2.getFirst()) + Math.min(arr1.getLast(), arr2.getLast())) / 2.0
    }

    val median1 = arr1.getMedian()
    val median2 = arr2.getMedian()

    if (median1 == median2) {
        return median1
    }

    if (median1 > median2) {
        return median(
            arr1.subArray(0, arr1.size / 2 + 1),
            arr2.subArray((arr2.size - 1) / 2, arr2.size)
        )
    }
    return median(arr1.subArray(0, arr1.size / 2), arr2.subArray((arr2.size - 1) / 2, arr2.size))
}


class MedianOfArrays {

}