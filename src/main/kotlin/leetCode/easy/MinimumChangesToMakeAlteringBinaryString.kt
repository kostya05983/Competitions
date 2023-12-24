package leetCode.easy

class MinimumChangesToMakeAlteringBinaryString {
    fun minOperations(s: String): Int {
        var nextStartFirst = '0'

        var countFirst = if (s[0] == '1') 1 else 0
        var countSecond = if (s[0] == '0') 1 else 0

        for (i in 1 until s.length) {
            val ch = s[i]

            if (ch == nextStartFirst) {
                countFirst++
            } else {
                countSecond++
            }
            nextStartFirst = reverse(nextStartFirst)
        }

        return minOf(countFirst, countSecond)
    }

    private fun reverse(ch: Char): Char {
        return when (ch) {
            '1' -> '0'
            else -> '1'
        }
    }
}

fun main(args: Array<String>) {
    val solution = MinimumChangesToMakeAlteringBinaryString()
    println(solution.minOperations("0100"))
    println(solution.minOperations("10"))
    println(solution.minOperations("1111"))
}