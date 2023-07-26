package yandex

fun main(args: Array<String>) {
    val n = readLine()?.toInt()!!
    val result = mutableListOf<String>()

    var previous = ""
    for (i in 0 until n) {
        val line = readLine()!!
        if (previous == line) {
            continue
        }
        previous = line
        result.add(line)
    }
    println(result.joinToString("\n"))
}