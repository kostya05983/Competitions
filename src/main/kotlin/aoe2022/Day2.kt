package aoe2022

import java.io.File

class Day2 {
    fun solve(): Int {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_2.txt").readLines()
        var total = 0
        for (line in input) {
            val splitted = line.split(" ")
            val left = splitted[0]
            val right = splitted[1]

            when {
                left == "A" && right == "X" -> {
                    total += 4
                }

                left == "A" && right == "Y" -> {
                    total += 8
                }

                left == "A" && right == "Z" -> {
                    total += 3
                }

                left == "B" && right == "X" -> {
                    total += 1
                }

                left == "B" && right == "Y" -> {
                    total += 5
                }

                left == "B" && right == "Z" -> {
                    total += 9
                }

                left == "C" && right == "X" -> {
                    total += 7
                }

                left == "C" && right == "Y" -> {
                    total += 2
                }

                left == "C" && right == "Z" -> {
                    total += 6
                }
            }
        }
        return total
    }

    fun solve2(): Int {
        val input =
            File("/home/kostya05983/Projects/github/Competitions/src/main/resources/aoe/input_day_2.txt").readLines()
        var total = 0
        for (line in input) {
            val splitted = line.split(" ")
            val left = splitted[0]
            val right = splitted[1]

            when {
                right == "X" -> {
                    total += getLose(left)
                }

                right == "Y" -> {
                    total += getDraw(left)
                }

                right == "Z" -> {
                    total += getWin(left)
                }

                else -> throw IllegalArgumentException("Wrong argument=$right")
            }
        }
        return total
    }

    private fun getWin(left: String): Int {
        if (left == "A") return 8
        if (left == "B") return 9
        if (left == "C") return 7
        throw IllegalArgumentException("argument=$left")
    }

    private fun getLose(left: String): Int {
        if (left == "A") return 3
        if (left == "B") return 1
        if (left == "C") return 2
        throw IllegalArgumentException("argument=$left")
    }

    private fun getDraw(left: String): Int {
        if (left == "A") return 4
        if (left == "B") return 5
        if (left == "C") return 6
        throw IllegalArgumentException("argument=$left")
    }
}

fun main(args: Array<String>) {
    println(Day2().solve2())
}