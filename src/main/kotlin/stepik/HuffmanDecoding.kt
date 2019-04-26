package stepik

import java.util.*

private fun decode(codes: Map<String, Char>, line: String): String {
    var currentLine = line
    val sb = StringBuilder()
    while (currentLine.isNotEmpty()) {
        for ((key, value) in codes) {
            if (currentLine.startsWith(key)) {
                currentLine = currentLine.substring(key.length)
                sb.append(value)
            }
        }
    }
    return sb.toString()
}


fun main() {
    val scanner = Scanner(System.`in`)
    val firstLine = scanner.nextLine().split(" ")

    val amountChars = firstLine[0].toInt()

    val map = mutableMapOf<String, Char>()

    for (i in 0 until amountChars) {
        val line = scanner.nextLine().split(" ")
        val char = line[0].replace(":", "")[0]
        map[line[1]] = char
    }

    val encodeStr = scanner.nextLine()

    val decode = decode(map, encodeStr)
    println(decode)
}