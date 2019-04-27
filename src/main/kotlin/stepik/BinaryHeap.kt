package stepik

import java.util.*

class BinaryHeap {
    companion object {
        private const val START_SIZE = 10
    }

    private var array = LongArray(START_SIZE)
    private var currentSize = 0

    fun insert(new: Long) {
        if (currentSize >= array.size) {
            resize()
        }

        array[currentSize] = new
        currentSize++
        siftUp()
    }

    private fun getParentIndex(index: Int): Int {
        return (index - 1) / 2
    }

    private fun siftUp() {
        var current = currentSize - 1
        while (array[current] > array[getParentIndex(current)]) {
            swap(current, getParentIndex(current))
            current = getParentIndex(current)
        }
    }

    private fun swap(i: Int, j: Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }

    private fun resize() {
        val newSize = array.size + 10
        array = array.copyOf(newSize)
    }

    private fun isLeaf(index: Int): Boolean {
        if (index >= (currentSize / 2) && index <= currentSize) {
            return true
        }
        return false
    }

    private fun leftChild(index: Int): Int {
        return index * 2 + 1
    }

    private fun rightChild(index: Int): Int {
        return index * 2 + 2
    }

    private fun sort(index: Int) {
        if (isLeaf(index)) return

        if (array[index] < array[leftChild(index)] || array[index] < array[rightChild(index)]) {
            if (array[leftChild(index)] > array[rightChild(index)]) {
                swap(index, leftChild(index))
                sort(leftChild(index))
            } else {
                swap(index, rightChild(index))
                sort(rightChild(index))
            }
        }
    }

    fun extractMax(): Long {
        val extracted = array[0]
        array[0] = array[currentSize - 1]
        currentSize--
        sort(0)
        return extracted
    }
}

private const val INSERT = "Insert"
private const val EXTRACT_MAX = "ExtractMax"

private fun interpreter(heap: BinaryHeap, s: String) {
    when {
        s.startsWith(INSERT) -> {
            val list = s.split(" ")
            heap.insert(list[1].toLong())
        }
        s.startsWith(EXTRACT_MAX) -> {
            println(heap.extractMax())
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val amountLines = scanner.nextLine().toInt()

    val heap = BinaryHeap()

    for (i in 0 until amountLines) {
        interpreter(heap, scanner.nextLine())
    }
}