package stepik

import java.util.*

data class Good(val priceForWeight: Double, var size: Int)

fun main() {
    val scanner = Scanner(System.`in`)

    val firstLine = scanner.nextLine().split(" ")
    val n = firstLine[0].toInt()
    val maxWeight = firstLine[1].toInt()

    val priceForWeight = LinkedList<Good>()
    for (i in 0 until n) {
        val line = scanner.nextLine().split(" ")
        priceForWeight.add(Good(line[0].toDouble() / line[1].toDouble(), line[1].toInt()))
    }

    println(String.format("%.3f", findMaximumPrice(maxWeight, priceForWeight)))
}

fun findMaximumPrice(maxWeight: Int, prices: LinkedList<Good>): Double {
    val sortedBy = prices.sortedByDescending {
        it.priceForWeight
    }

    var remainingSize = maxWeight
    var result = 0.0

    for (i in 0 until sortedBy.size) {
        while (remainingSize != 0 && sortedBy[i].size != 0) {
            result += sortedBy[i].priceForWeight
            remainingSize--
            sortedBy[i].size--
        }

        if (remainingSize == 0)
            break
    }

    return result
}