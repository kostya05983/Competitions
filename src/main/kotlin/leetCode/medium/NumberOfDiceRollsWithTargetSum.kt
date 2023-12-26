package leetCode.medium

class NumberOfDiceRollsWithTargetSum {
    private val mod = 1_000_000_007
    private val memo = HashMap<String, Int>()

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        if (n == 0 && target == 0) {
            return 1
        }
        if (n > target || n * k < target) {
            return 0
        }

        val key = "$n $target"
        val memorized = memo[key]
        if (memorized != null) {
            return memorized
        }

        var res = 0
        for (i in 1..k) {
            if (target >= i) {
                res = (res + numRollsToTarget(n - 1, k, target - i)).rem(mod)
            } else {
                break
            }
        }
        memo[key] = res

        return res
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfDiceRollsWithTargetSum()
    println(solution.numRollsToTarget(1, 6, 3))
    println(solution.numRollsToTarget(2, 6, 7))
    println(solution.numRollsToTarget(30, 30, 500))
}