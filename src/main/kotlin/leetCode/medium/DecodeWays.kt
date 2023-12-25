package leetCode.medium

class DecodeWays {
    fun numDecodings(s: String): Int {
        if (s.isEmpty()) return 0

        val memory = HashMap<Int, Int>()
        return recursive(0, s, memory)
    }

    private fun recursive(i: Int, s: String, memory: HashMap<Int, Int>): Int {
        val n = s.length
        if (i == n) return 1
        val memorized = memory[i]
        if (memorized != null) return memorized

        if (s[i] == '0') return 0

        var count = recursive(i + 1, s, memory)
        if (i < n - 1 && (s[i] == '1' || s[i] == '2' && s[i + 1] < '7')) {
            count += recursive(i + 2, s, memory)
        }

        val result = count
        memory[i] = result

        return result
    }
}

fun main(args: Array<String>) {
    val solution = DecodeWays()
    println(solution.numDecodings("12"))
    println(solution.numDecodings("226"))
    println(solution.numDecodings("06"))
    println(solution.numDecodings("10"))
    println(solution.numDecodings("27"))
}