package leetCode.medium

class NumberOfLaserBeamsInBank {
    fun numberOfBeams(bank: Array<String>): Int {
        val rowCount = mutableListOf<Int>()

        for (element in bank) {
            val b = element
            val count = b.count { it == '1' }
            if (count == 0) continue

            rowCount.add(count)
        }

        var result = 0

        for (i in 0 until rowCount.size - 1) {
            val next = rowCount[i + 1]
            val current = rowCount[i]

            result += current * next
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfLaserBeamsInBank()
    println(solution.numberOfBeams(arrayOf("011001", "000000", "010100", "001000")))
    println(solution.numberOfBeams(arrayOf("000","111","000")))
}