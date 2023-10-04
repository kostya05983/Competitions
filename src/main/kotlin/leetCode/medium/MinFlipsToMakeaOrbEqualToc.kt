package leetCode.medium

class MinFlipsToMakeaOrbEqualToc {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var count = 0

        var shiftA = a
        var shiftB = b
        var shiftC = c

        while (shiftA != 0 || shiftB != 0 || shiftC != 0) {
            val lastDigitC = shiftC.and(1)
            val lastDigitB = shiftB.and(1)
            val lastDigitA = shiftA.and(1)

            when {
                lastDigitC == 1 && lastDigitB == 0 && lastDigitA == 0 -> {
                    count++
                }

                lastDigitC == 0 -> {
                    count += lastDigitB
                    count += lastDigitA
                }
            }
            shiftC = shiftC.shr(1)
            shiftB = shiftB.shr(1)
            shiftA = shiftA.shr(1)
        }


        return count
    }
}

fun main(args: Array<String>) {
    val solution = MinFlipsToMakeaOrbEqualToc()
    println(solution.minFlips(2, 6, 5))
}