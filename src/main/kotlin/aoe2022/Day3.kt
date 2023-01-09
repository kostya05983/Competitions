package aoe2022

import java.io.File
import java.util.*

class Day3 {
    fun solve(): Int {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_3.txt").readLines()

        val total = mutableListOf<Pair<Int, Int>>()

        for (j in input.indices) {
            val line = input[j]
            val half = line.length / 2
            val set = hashSetOf<Char>()
            val alreadyAdded = hashSetOf<Char>()
            for (i in line.indices) {
                val item = line[i]
                if (i < half) {
                    set.add(item)
                } else if (set.contains(item) && !alreadyAdded.contains(item)) {
                    alreadyAdded.add(item)

                    val priority = if (item.isUpperCase()) {
                        item.toInt() - 38
                    } else {
                        item.toInt() - 96
                    }
                    total.add(
                        Pair(j, priority)
                    )
                }
            }
        }

        return total.sumBy { it.second }
    }

    fun solve2(): Int {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_3.txt").readLines()

        val total = mutableListOf<Pair<Int, Int>>()

        var set = hashSetOf<Char>()
        for (j in input.indices) {
            val line = input[j]

            if (j.rem(3) == 0) {
                for (element in set) {
                    total.add(Pair(j / 3, element.toPriority()))
                }

                set.clear()
                for (ch in line) {
                    set.add(ch)
                }
                continue
            }

            val newSet = hashSetOf<Char>()
            for (ch in line) {
                if (set.contains(ch)) {
                    newSet.add(ch)
                }
            }
            set = newSet
        }
        for (element in set) {
            total.add(Pair(100, element.toPriority()))
        }

        return total.sumBy { it.second }
    }

    private fun Char.toPriority(): Int = if (isUpperCase()) {
        toInt() - 38
    } else {
        toInt() - 96
    }
}

fun main(args: Array<String>) {
    println(Day3().solve2())
}