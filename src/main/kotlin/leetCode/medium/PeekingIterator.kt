package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.NoSuchElementException

class PeekingIterator(
    private val iterator: Iterator<Int>
) : Iterator<Int> {
    private var peek: Int? = null

    fun peek(): Int {
        if (peek == null) peek = getNextOrNull()
        return peek ?: throw NoSuchElementException()
    }

    override fun next(): Int {
        if (peek != null) {
            val result = peek
            peek = null
            return result ?: throw NoSuchElementException()
        }

        return iterator.next()
    }

    override fun hasNext(): Boolean {
        return peek != null || iterator.hasNext()
    }

    private fun getNextOrNull(): Int? {
        return if (iterator.hasNext()) iterator.next() else null
    }
}

fun main(args: Array<String>) {
    val solution = PeekingIterator(intArrayOf(1, 2, 3).iterator())
    assertEquals(1, solution.next())
    assertEquals(2, solution.peek())
    assertEquals(2, solution.next())
    assertEquals(3, solution.next())
    assertEquals(false, solution.hasNext())
}