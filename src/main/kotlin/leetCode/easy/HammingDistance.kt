package leetCode.easy


class HammingDistance {
    fun hammingDistance(x: Int, y: Int): Int {
        var xor = x xor y
        var count = 0

        while (xor > 0) {
            count += xor and 1
            xor = xor shr 1
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = HammingDistance()
    val test1 = solution.hammingDistance(1, 4)
    require(test1 == 2)

    val test2 = solution.hammingDistance(3, 1)
    require(test2 == 1)
}