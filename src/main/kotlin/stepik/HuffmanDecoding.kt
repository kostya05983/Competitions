package stepik

import java.util.*

data class HuffmanNode(
    var left: Node? = null,
    var right: Node? = null,
    val char: Char,
    val code: String
)

//private fun from

fun main() {
    val scanner = Scanner(System.`in`)
    val firstLine = scanner.nextLine().split(" ")

    val amountChars = firstLine[0].toInt()
    val lineLength = firstLine[1].toInt()

    for (i in 0 until amountChars) {
        val line = scanner.nextLine().split(" ")
        val char = line[0].replace(":", "")[0]
        val node = HuffmanNode(null, null, char, line[2])
    }
}