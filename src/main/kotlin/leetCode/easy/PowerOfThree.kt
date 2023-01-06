package leetCode.easy

class PowerOfThree {
    private val mask = 0b1000101010001101011001111011011

    fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && mask.rem(n) == 0
    }
}

fun main(args: Array<String>) {
    println(PowerOfThree().isPowerOfThree(27))
    println(PowerOfThree().isPowerOfThree(0))
    println(PowerOfThree().isPowerOfThree(-1))
}