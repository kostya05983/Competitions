package leetCode.easy

class MinimumBitFlipsConvertNumber {
    fun minBitFlips(start: Int, goal: Int): Int {
        var xor = start xor goal
        var count = 0

        while (xor > 0) {
            count += xor and 1
            xor = xor shr 1
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = MinimumBitFlipsConvertNumber()
    solution.minBitFlips(1, 4)
}