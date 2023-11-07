package leetCode.medium

class EliminateMaximumNumberOfMonsters {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val time = IntArray(dist.size) { Math.ceil(dist[it] / speed[it].toDouble()).toInt() }
        time.sort()

        var store = time[0] - 1
        for (i in 0 until time.size - 1) {
            val diff = time[i + 1] - time[i]
            if (diff > 1) {
                store += (diff - 1)
            }

            if (diff == 0) {
                if (store > 0) {
                    store--
                    continue
                }
                return i + 1
            }
        }

        return time.size
    }
}

fun main(args: Array<String>) {
    val solution = EliminateMaximumNumberOfMonsters()
    println(solution.eliminateMaximum(intArrayOf(1, 3, 4), intArrayOf(1, 1, 1)))
    println(solution.eliminateMaximum(intArrayOf(1, 1, 2, 3), intArrayOf(1, 1, 1, 1)))
    println(solution.eliminateMaximum(intArrayOf(3, 2, 4), intArrayOf(5, 3, 2)))
    println(solution.eliminateMaximum(intArrayOf(1, 2, 3, 4, 5, 6, 7), intArrayOf(1, 1, 2, 2, 2, 2, 2)))
    println(solution.eliminateMaximum(intArrayOf(4, 2, 3), intArrayOf(2, 1, 1)))
}