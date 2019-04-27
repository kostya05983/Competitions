package stepik

import java.util.*

class BinaryHeap {

    fun insert(new: Int) {

    }

    fun extractMax(): Int {
        return -1
    }
}

private const val INSERT = "Insert"
private const val EXTRACT_MAX = "ExtractMax"

private fun interpreter(heap: BinaryHeap, s: String) {
    when {
        s.startsWith(INSERT) -> {
            val list = s.split(" ")
            heap.insert(list[1].toInt())
        }
        s.startsWith(EXTRACT_MAX) -> {

        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val amountLines = scanner.nextLine().toInt()

    for (i in 0 until amountLines) {

    }
}