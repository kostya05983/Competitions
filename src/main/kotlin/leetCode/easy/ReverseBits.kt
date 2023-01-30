package leetCode.easy

class ReverseBits {
    private val cache = mutableMapOf<Int, Int>()

    fun reverseBits(n: Int): Int {
        if (cache.contains(n)) return cache[n]!!

        var temp = n.ushr(16).or(n.shl(16))

        temp = (temp.ushr(8).and(0x00ff00ff)).or(temp.shl(8).and(-0x00ff00ff))
        temp = (temp.ushr(4).and(0x0f0f0f0f)).or(temp.shl(4).and(-0x0f0f0f0f))
        temp = (temp.ushr(2).and(0x33333333)).or(temp.shl(2).and(-0x33333333))
        temp = (temp.ushr(1).and(0x55555555)).or(temp.shl(1).and(-0x55555555))

        cache[n] = temp

        return temp
    }
}

fun main(args: Array<String>) {
    val solution = ReverseBits()
    val test1 = solution.reverseBits(-3)
    require(test1 == -1073741825) { "result $test1" }
}