package stepik.DotesAndLines

import java.util.*


private fun iterativeAnotherType(lines: Array<NewLine>, amountDotes: Int): IntArray {
    var amount = 0
    val intArray = IntArray(amountDotes)
    for (i in 0 until lines.size) {
        when {
            lines[i].type == -1 -> amount++
            lines[i].type == +1 -> amount--
            else -> intArray[lines[i].number] = amount
        }
    }

    return intArray
}

private class NewLine(val dote: Int, val type: Int, val number: Int)

fun main() {
    val scanner = Scanner(System.`in`)

    val firstLine = scanner.nextLine().split(" ")

    val amountLines = firstLine[0].toInt()
    val amountDotes = firstLine[1].toInt()

    val lines = Array(amountLines * 2 + amountDotes) { NewLine(0, -2, -1) }

    for (i in 0 until amountLines * 2 step 2) {
        val line = scanner.nextLine()
        val index = line.indexOf(" ")

        val first = line.substring(0, line.indexOf(" "))
        val second = line.substring(index + 1)
        lines[i] = NewLine(first.toInt(), -1, -1)
        lines[i + 1] = NewLine(second.toInt(), +1, -1)
    }

    val dotesStr = scanner.nextLine()

    var index = -1
    val start = amountLines * 2

    for ((position, i) in (start until start + amountDotes - 1).withIndex()) {
        val old = index + 1
        index = dotesStr.indexOf(' ', old)
        lines[i] = NewLine(dotesStr.substring(old, index).toInt(), 0, position)
    }

    lines[start + amountDotes - 1] = NewLine(dotesStr.substring(index + 1).toInt(), 0, amountDotes - 1)

    lines.sortWith(Comparator { o1: NewLine, o2: NewLine ->
        if (o1.dote != o2.dote) {
            return@Comparator o1.dote.compareTo(o2.dote)
        } else {
            return@Comparator o1.type.compareTo(o2.type)
        }
    })


    val sb = StringBuilder()
    val result = iterativeAnotherType(lines, amountDotes)
    for (answer in result) {
        sb.append(answer).append(' ')
    }

    print(sb.toString())
}