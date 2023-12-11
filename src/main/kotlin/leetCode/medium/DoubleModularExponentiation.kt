package leetCode.medium

class DoubleModularExponentiation {
    fun getGoodIndices(variables: Array<IntArray>, target: Int): List<Int> {
        val result = mutableListOf<Int>()

        for (i in 0 until variables.size) {
            val (a, b, c, m) = variables[i]
            val res = (Math.pow(Math.pow(a.toDouble(), b.toDouble()).rem(10), c.toDouble()).rem(m)).toInt()

            if (res == target) {
                result.add(i)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = DoubleModularExponentiation()
    println(solution.getGoodIndices(arrayOf(intArrayOf(53, 38, 9, 33)), 1))
//    println(
//        solution.getGoodIndices(
//            arrayOf()
//        )
//    )
}