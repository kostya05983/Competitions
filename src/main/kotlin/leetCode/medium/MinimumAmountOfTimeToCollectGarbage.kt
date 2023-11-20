package leetCode.medium

class MinimumAmountOfTimeToCollectGarbage {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        val trucks = mutableMapOf(
            'P' to 0,
            'G' to 0,
            'M' to 0
        )
        val trucksPosition = mutableMapOf<Char, Int>(
            'P' to 0,
            'G' to 0,
            'M' to 0
        )

        var travelTime = 0
        for (i in garbage.indices) {
            val g = garbage[i]
            if (i != 0) travelTime += travel[i - 1]

            for (type in g) {
                val value = trucks[type]!!
                trucks[type] = value + 1 + (travelTime - trucksPosition[type]!!)
                trucksPosition[type] = travelTime
            }
        }

        return trucks.values.sum()
    }
}

fun main(args: Array<String>) {
    val solution = MinimumAmountOfTimeToCollectGarbage()
    println(solution.garbageCollection(arrayOf("G", "P", "GP", "GG"), intArrayOf(2, 4, 3)))
}