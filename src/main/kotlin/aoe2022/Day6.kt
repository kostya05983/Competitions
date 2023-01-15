package aoe2022

import java.io.File

class Day6 {
    fun solve(line: String): Int {
        val windowSize = 4
        val step = 1
        val set = mutableSetOf<Char>()

        var i = 0
        var j = 1
        while (i < line.length) {
            val ch = line[i]
            set.add(ch)

            if (j == windowSize) {
                if (set.size == 4) return i + 1
                set.clear()
                j = 1
                i = i - windowSize + 1 + step
                continue
            }
            i++
            j++
        }

        return -1
    }

    fun solve2(line: String): Int {
        val windowSize = 14
        val step = 1
        val set = mutableSetOf<Char>()

        var i = 0
        var j = 1
        while (i < line.length) {
            val ch = line[i]
            set.add(ch)

            if (j == windowSize) {
                if (set.size == 14) return i + 1
                set.clear()
                j = 1
                i = i - windowSize + 1 + step
                continue
            }
            i++
            j++
        }

        return -1
    }
}

fun main(args: Array<String>) {
    println(Day6().solve("bvwbjplbgvbhsrlpgdmjqwftvncz"))
    println(Day6().solve("nppdvjthqldpwncqszvftbrmjlhg"))
    println(Day6().solve("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
    println(Day6().solve("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    val input =
        File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_6.txt").readLines()
    println(Day6().solve(input[0]))

    println(Day6().solve2("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
    println(Day6().solve2("bvwbjplbgvbhsrlpgdmjqwftvncz"))
    println(Day6().solve2("nppdvjthqldpwncqszvftbrmjlhg"))
    println(Day6().solve2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
    println(Day6().solve2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    println(Day6().solve2(input[0]))
}