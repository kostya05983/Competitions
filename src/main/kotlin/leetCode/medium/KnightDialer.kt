package leetCode.medium

class KnightDialer {
    private val mod = 1000000007
    private val jumps = arrayOf(
        intArrayOf(4, 6),
        intArrayOf(6, 8),
        intArrayOf(7, 9),
        intArrayOf(4, 8),
        intArrayOf(3, 9, 0),
        intArrayOf(),
        intArrayOf(1, 7, 0),
        intArrayOf(2, 6),
        intArrayOf(1, 3),
        intArrayOf(2, 4)
    )

    private fun dp(remain: Int, square: Int, memory: Array<IntArray>): Int {
        if (remain == 0) return 1

        if (memory[remain][square] != 0) {
            return memory[remain][square]
        }

        var result = 0
        for (nextSquare in jumps[square]) {
            result = (result + dp(remain - 1, nextSquare, memory)).rem(mod)
        }

        memory[remain][square] = result

        return result
    }

    fun knightDialer(n: Int): Int {
        val memory = Array(n + 1) { IntArray(10) }

        var result = 0

        for (square in 0 until 10) {
            result = (result + dp(n - 1, square, memory)).rem(mod)
        }

        return result
    }
}