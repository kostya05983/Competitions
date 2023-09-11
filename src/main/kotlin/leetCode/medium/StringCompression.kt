package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class StringCompression {
    fun compress(chars: CharArray): Int {
        var writePointer = 0
        var readPointer = 0

        var subsequenceCount = 1
        while (readPointer < chars.size - 1) {
            if (chars[readPointer] != chars[readPointer + 1]) {
                writePointer += write(chars, writePointer, readPointer, subsequenceCount)
                subsequenceCount = 0
            }

            subsequenceCount++
            readPointer++
        }
        writePointer += write(chars, writePointer, readPointer, subsequenceCount)

        return writePointer
    }

    private fun write(chars: CharArray, writePointer: Int, readPointer: Int, subsequenceCount: Int): Int {
        chars[writePointer] = chars[readPointer]
        if (subsequenceCount != 1) {
            val number = "$subsequenceCount"

            for (i in number.indices) {
                val ch = number[i]
                chars[writePointer + i + 1] = ch
            }

            return 1 + number.length
        }
        return 1
    }
}

fun main(args: Array<String>) {
    val solution = StringCompression()
    val example1 = solution.compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c'))
    assertEquals(6, example1)

    val example2 = solution.compress(charArrayOf('a'))
    assertEquals(1, example2)

    val example3 = solution.compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'))
    assertEquals(4, example3)
}