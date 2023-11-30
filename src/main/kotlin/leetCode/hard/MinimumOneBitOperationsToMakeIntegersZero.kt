package leetCode.hard

class MinimumOneBitOperationsToMakeIntegersZero {
    fun minimumOneBitOperations(n: Int): Int {
        var result = 0
        var k = 0
        var mask = 1

        while (mask <= n) {
            if (n.and(mask) != 0) {
                result = 1.shl(k + 1) - 1 - result
            }
            mask = mask.shl(1)
            k++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MinimumOneBitOperationsToMakeIntegersZero()
    println(solution.minimumOneBitOperations(3))
    println(solution.minimumOneBitOperations(6))
}