package leetCode.medium

class MinimumNumberOfDaysToMakeBouquets {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        var minDay = 0
        var remainBouquets = m

        val positions = HashMap<Int, Int>()
        for (i in 0 until bloomDay.size) {
            positions[i] = bloomDay[i]
        }

        bloomDay.sort()

        var lastDay = 0
        var currentK = k
        for (i in 0 until bloomDay.size) {
            val day = bloomDay[i]
            lastDay = maxOf(day, lastDay)

            if (i == 0 || lastDay - day == 1) {
                currentK--
                if (currentK == 0) {
                    remainBouquets--
                    currentK = k
                }
            } else {
                val adjacent = positions[i]!!
                lastDay = maxOf(adjacent, lastDay)

            }
        }


        return if (remainBouquets > 0) -1 else minDay
    }
}

fun main(args: Array<String>) {
    val solution = MinimumNumberOfDaysToMakeBouquets()
    println(solution.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1))
    println(solution.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 2))
    println(solution.minDays(intArrayOf(7, 7, 7, 7, 12, 7, 7), 2, 3))
}