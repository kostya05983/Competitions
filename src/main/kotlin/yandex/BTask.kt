package yandex

fun main(args: Array<String>) {
    val n = readLine()?.toInt()!!

    var counter = 0
    var max = 0
    for (i in 0 until n) {
        val line = readLine()

        if (line != "1") {
            max = maxOf(counter, max)
            counter = 0
        } else {
            counter++
        }
    }
    max = maxOf(counter, max)

    println(max)
}