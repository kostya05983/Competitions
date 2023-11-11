package leetCode.easy

class DistributeCandies {
    fun distributeCandies(n: Int, limit: Int): Int {
        return distributeCandies(n, 0, 0, limit)
    }

    private fun distributeCandies(n: Int, index: Int, current: Int, limit: Int): Int {
        if (n == 0 && current <= limit) return 1
        if (current > limit && index == 2) return 0
        if (index > 2) return 0

        val give = if (current < limit) distributeCandies(n - 1, index, current + 1, limit) else 0
        val notGive = distributeCandies(n, index + 1, 0, limit)

        return give + notGive
    }
}

fun main(args: Array<String>) {
    val solution = DistributeCandies()

    println(solution.distributeCandies(5, 2))
    println(solution.distributeCandies(3, 3))
    println(solution.distributeCandies(6, 2))
}