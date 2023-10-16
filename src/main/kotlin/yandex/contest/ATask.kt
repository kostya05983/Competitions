package yandex.contest

fun main(args: Array<String>) {
    val j = readLine()!!
    val s = readLine()!!

    val jSet = j.toSet()

    var result = 0
    for (ch in s) {
        if (jSet.contains(ch)) {
            result++
        }
    }

    println(result)
}