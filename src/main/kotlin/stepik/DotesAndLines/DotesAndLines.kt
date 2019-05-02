package stepik.DotesAndLines

import java.util.*

private data class Line(val start: Int, val end: Int)

private fun contains(dot: Int, line: Line): Boolean {
    return dot >= line.start && dot <= line.end
}

private class SearchAlgorithm {
    fun countAmountLinesForDotesBinary(lines: Array<Line>, left: Int, right: Int, dot: Int): Int {
        val middle = (right - left) / 2 + left
        var amount = 0

        if (right >= left) {
            if (contains(dot, lines[middle])) {
                for (i in left..right) {
                    if (contains(dot, lines[i]))
                        amount++
                }
                return amount
            }

            amount += if (lines[middle].end > dot) {
                countAmountLinesForDotesBinary(lines, left, middle - 1, dot)
            } else {
                countAmountLinesForDotesBinary(lines, middle + 1, right, dot)
            }
        }

        return amount
    }

    fun iterativeBinarySearch(lines: Array<Line>, left: Int, right: Int, dot: Int): Int {
        var middle = (right - left) / 2 + left
        var amount = 0

        var currentLeft = left
        var currentRight = right

        while (!contains(dot, lines[middle]) && currentRight >= currentLeft) {
            middle = (currentRight - currentLeft) / 2 + currentLeft
            if (lines[middle].end > dot) {
                currentRight = middle - 1
            } else {
                currentLeft = middle + 1
            }
        }

        if (contains(dot, lines[middle])) {
            for (i in left..right) {
                if (contains(dot, lines[i]))
                    amount++
            }
        }
        return amount
    }
}


fun main() {
    val startTime = System.currentTimeMillis()
    val scanner = Scanner(System.`in`)

    val firstLine = scanner.nextLine().split(" ")

    val amountLines = firstLine[0].toInt()
    val amountDotes = firstLine[1].toInt()

    val lines = Array(amountLines) { Line(0, 0) }

    for (i in 0 until amountLines) {
        val line = scanner.nextLine()
        val index = line.indexOf(" ")
        val first = line.substring(0, line.indexOf(" "))
        val second = line.substring(index + 1)
        lines[i] = Line(first.toInt(), second.toInt())
    }

    val dotesStr = scanner.nextLine()

    val dotes = IntArray(amountDotes)

    var index = -1
    for (i in 0 until amountDotes - 1) {
        val old = index + 1
        index = dotesStr.indexOf(' ', old)
        dotes[i] = dotesStr.substring(old, index).toInt()
    }
    dotes[amountDotes - 1] = dotesStr.substring(index + 1).toInt()

    lines.sortBy {
        it.end
    }

    val searchAlgorithm = SearchAlgorithm()

    val sb = StringBuilder()
    for (dote in dotes) {
        sb.append(searchAlgorithm.iterativeBinarySearch(lines, 0, lines.size - 1, dote)).append(" ")
    }
    print(sb.toString())

    println(System.currentTimeMillis() - startTime)
}
//
//6 6
//0 3
//1 3
//2 3
//3 4
//3 5
//3 6
//1 2 3 4 5 6