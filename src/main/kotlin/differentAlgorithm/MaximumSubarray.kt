package differentAlgorithm


fun findSubArray(arr: IntArray): Int {
    var outSum = 0
    var sum = 0
    for (i in 0 until arr.size) {
        sum += arr[i]
        if (sum < 0)
            sum = 0
        if (outSum < sum) {
            outSum = sum
        }
    }
    return outSum
}

fun main() {
    println(findSubArray(intArrayOf(4, 5, -23, 45, 23, 12)))
    println(maxSubArraySum(intArrayOf(4, 5, -23, 45, 23, 12), 0, 5))
}

fun maxSubArraySum(arr: IntArray, l: Int, h: Int): Int {
    // Base Case: Only one element
    if (l == h)
        return arr[l]

    // Find middle point
    val m = (l + h) / 2

    /* Return maximum of following three
    possible cases:
    a) Maximum subarray sum in left half
    b) Maximum subarray sum in right half
    c) Maximum subarray sum such that the
    subarray crosses the midpoint */
    return Math.max(
        Math.max(
            maxSubArraySum(arr, l, m),
            maxSubArraySum(arr, m + 1, h)
        ),
        maxCrossingSum(arr, l, m, h)
    )
}

fun maxCrossingSum(arr: IntArray, l: Int, m: Int, h: Int): Int {
    // Include elements on left of mid.
    var sum = 0
    var left_sum = Integer.MIN_VALUE
    for (i in m downTo l) {
        sum = sum + arr[i]
        if (sum > left_sum)
            left_sum = sum
    }

    // Include elements on right of mid
    sum = 0
    var right_sum = Integer.MIN_VALUE
    for (i in m + 1..h) {
        sum = sum + arr[i]
        if (sum > right_sum)
            right_sum = sum
    }

    // Return sum of elements on left
    // and right of mid
    return left_sum + right_sum
}