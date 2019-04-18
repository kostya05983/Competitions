package hackerRank

// Complete the hackerRank.birthday function below.
fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    var total = 0

    if (s.size < m) {
        return 0
    }

    // Compute sum of first window of size m
    var max_sum = 0
    for (i in 0 until m)
        max_sum += s[i]

    // Compute sums of remaining windows by
    // removing first element of previous
    // window and adding last element of
    // current window.
    var window_sum = max_sum
    if(window_sum==d) total++

    for (i in m until s.size) {
        window_sum += s[i] - s[i - m]
        if(window_sum == d) total++
    }

    return total
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val dm = readLine()!!.trimEnd().split(" ")

    val d = dm[0].toInt()

    val m = dm[1].toInt()

    val result = birthday(s, d, m)

    println(result)
}
