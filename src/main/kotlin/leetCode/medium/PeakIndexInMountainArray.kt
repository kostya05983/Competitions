package leetCode.medium

class PeakIndexInMountainArray {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = 0
        var right = arr.size - 1

        while (left != right) {
            val m = (left + right) / 2
            val value = arr[m]
            val next = arr[m + 1]
            when {
                next > value -> {
                    left = m + 1
                }

                next < value -> {
                    right = m
                }
            }
        }
        return left
    }
}