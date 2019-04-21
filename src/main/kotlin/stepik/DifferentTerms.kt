package stepik

import java.util.*


fun findResult(n: Int): LinkedList<Int> {
    var innerSum = n
    var sum = 0
    val result = LinkedList<Int>()

    while (innerSum - (sum + 1) > sum + 1) {
        sum++
        result.add(sum)
        innerSum -= sum
    }

    result.add(innerSum)

    return result
}


fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().toInt()

    val result = findResult(n)
    println(result.size)

    for (i in 0 until result.size) {
        print("${result[i]} ")
    }
}