package stepik

import java.util.*


private fun countSort(array: IntArray): IntArray {
    val bArray = IntArray(array.max()!!+1)

    for (j in 0 until array.size) {
        bArray[array[j]] = bArray[array[j]] + 1
    }
    for (i in 1 until bArray.size) {
        bArray[i] = bArray[i] + bArray[i - 1]
    }

    val result = IntArray(array.size)
    for (j in array.size-1 downTo 0) {
        result[bArray[array[j]]-1] = array[j]
        bArray[array[j]] = bArray[array[j]] - 1
    }

    return result
}

fun main() {
    val scanner = Scanner(System.`in`)

    val amount = scanner.nextLine().toInt()

    val list = scanner.nextLine().split(' ').map { it.toInt() }.toIntArray()

    val sort = countSort(list)
    sort.forEach {
        print("$it ")
    }
}