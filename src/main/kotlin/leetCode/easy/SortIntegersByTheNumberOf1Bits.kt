package leetCode.easy

class SortIntegersByTheNumberOf1Bits {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith { o1, o2 ->
            val leftBitCount = Integer.bitCount(o1)
            val rightBitCount = Integer.bitCount(o2)
            if (leftBitCount == rightBitCount) {
                o1.compareTo(o2)
            } else {
                leftBitCount.compareTo(rightBitCount)
            }
        }.toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution = SortIntegersByTheNumberOf1Bits()
    println(solution.sortByBits(intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1)).toList())
}