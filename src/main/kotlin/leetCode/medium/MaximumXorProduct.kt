package leetCode.medium

class MaximumXorProduct {
    fun maximumXorProduct(a: Long, b: Long, n: Int): Int {
        var max = 0L

        val powered = Math.max(2.0, n.toDouble()).toLong()

        var powed = 1L
        for (step in 0..n) {
            val xored = (a xor powed) * (b xor powed)
            max = maxOf(xored, powed)

            powed *= 2
        }

        return max.rem(1_000_000_007).toInt()
    }
}

fun main(args: Array<String>) {
    val solution = MaximumXorProduct()
    println(solution.maximumXorProduct(12, 5, 4))
    println(solution.maximumXorProduct(6, 7, 5))
    println(solution.maximumXorProduct(1, 6, 3))
}