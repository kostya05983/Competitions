package yandex

fun main(args: Array<String>) {
    val a = readLine()!!
    val b = readLine()!!
    if (a.length != b.length) {
        println(0)
        return
    }

    val array = IntArray(26) { 0 }

    for (ch in a) {
        array[ch - 'a']++
    }

    for (ch in b) {
        array[ch - 'a']--
    }

    for (i in array) {
        if (i != 0) {
            println(0)
            return
        }
    }

    println(1)
}