package aoe2022

import java.io.File

class Day4 {
    data class Range(val start: Int, val end: Int) {
        fun include(range: Range): Boolean {
            //----0123--
            //------2345--
            if (range.start >= start && range.end <= end) {
                return true
            }

            if (start >= range.start && end <= range.end) {
                return true
            }

            return false
        }

        fun intersect(range: Range): Boolean {
            if (range.start in start..end) {
                return true
            }
            if (range.end in start..end) {
                return true
            }
            if (start in range.start..range.end) {
                return true
            }
            if (end in range.start..range.end) {
                return true
            }

            return false
        }
    }

    fun solve(): Int {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_4.txt").readLines()
        var counter = 0
        for (line in input) {
            val splitted = line.split(",")
            val leftRange = getRange(splitted[0])
            val rightRange = getRange(splitted[1])

            if (leftRange.include(rightRange)) {
                counter++
            }
        }

        return counter
    }

    fun solve2(): Int {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_4.txt").readLines()
        var counter = 0
        for (line in input) {
            val splitted = line.split(",")
            val leftRange = getRange(splitted[0])
            val rightRange = getRange(splitted[1])

            if (leftRange.intersect(rightRange)) {
                counter++
            }
        }

        return counter
    }

    private fun getRange(str: String): Range {
        val splitted = str.split("-")
        return Range(splitted[0].toInt(), splitted[1].toInt())
    }
}

fun main(args: Array<String>) {
    println(Day4().solve2())
}