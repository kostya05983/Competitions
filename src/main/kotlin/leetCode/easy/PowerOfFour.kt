package leetCode.easy

class PowerOfFour {
    private val mask = 0b01010101010101010101010101010101

    fun isPowerOfFour(n: Int): Boolean {
        val previous = n - 1
        val isOneDigit = n.and(previous) == 0

        return isOneDigit && n.or(mask) == mask
    }
}

fun main(args: Array<String>) {
    println(PowerOfFour().isPowerOfFour(16))
    println(PowerOfFour().isPowerOfFour(5))
    println(PowerOfFour().isPowerOfFour(1))
}