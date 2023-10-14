package leetCode.easy

import java.util.Stack

class LastVisitedIntegers {
    fun lastVisitedIntegers(words: List<String>): List<Int> {
        val result = mutableListOf<Int>()
        val seenIntegers = mutableListOf<Int>()

        var prevCount = 0
        for (word in words) {
            when {
                word == "prev" -> {
                    prevCount++
                    val index = seenIntegers.size - prevCount
                    if (index >= 0) {
                        result.add(seenIntegers[index])
                    } else {
                        result.add(-1)
                    }
                }

                else -> {
                    prevCount = 0
                    seenIntegers.add(word.toInt())
                }
            }
        }

        return result
    }
}

fun main(args: Array<String>) {

}