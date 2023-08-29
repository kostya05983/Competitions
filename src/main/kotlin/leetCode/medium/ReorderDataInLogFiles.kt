package leetCode.medium

import org.junit.jupiter.api.Assertions.*
import kotlin.math.log


class ReorderDataInLogFiles {

    fun reorderLogFiles(logs: Array<String>): Array<String> {
        logs.sortWith(Comparator { left, right ->
            val (leftIdentifier, leftContent, isLeftDigit) = getInfo(left)
            val (rightIdentifier, rightContent, isRightDigit) = getInfo(right)

            return@Comparator when {
                isLeftDigit && isRightDigit -> {
                    0
                }

                !isLeftDigit && isRightDigit -> {
                    -1
                }

                isLeftDigit -> {
                    1
                }

                else -> {
                    val compare = leftContent.compareTo(rightContent)

                    if (compare == 0) {
                        leftIdentifier.compareTo(rightIdentifier)
                    } else {
                        compare
                    }
                }
            }
        })

        return logs
    }

    private fun getInfo(value: String): Triple<String, String, Boolean> {
        val content = value.substringAfter(" ")

        return Triple(
            value.substringBefore(" "),
            content,
            content.substringBefore(" ").all { it.isDigit() }
        )
    }
}

fun main(args: Array<String>) {
    val solution = ReorderDataInLogFiles()
    val example1 = solution.reorderLogFiles(
        arrayOf(
            "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        )
    )
    assertArrayEquals(
        arrayOf(
            "let1 art can",
            "let3 art zero",
            "let2 own kit dig",
            "dig1 8 1 5 1",
            "dig2 3 6"
        ),
        example1
    )

    val example2 = solution.reorderLogFiles(
        arrayOf(
            "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"
        )
    )

    assertArrayEquals(
        arrayOf(
            "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"
        ),
        example2
    )
}