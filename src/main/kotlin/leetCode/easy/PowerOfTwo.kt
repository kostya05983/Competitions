package leetCode.easy

class PowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 0) return false

        return Integer.bitCount(n) == 1
    }
}