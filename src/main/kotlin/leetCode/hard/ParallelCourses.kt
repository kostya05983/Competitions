package leetCode.hard

class ParallelCourses {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val relationMap = mutableMapOf<Int, MutableList<Int>>()

        for ((from, to) in relations) {
            relationMap[to] = relationMap.getOrDefault(to, mutableListOf()).also {
                it.add(from)
            }
        }

        var max = time.max()

        for (entry in relationMap) {
            max = maxOf(max, maxBfs(entry.key, relationMap, time))
        }

        return max
    }

    private val memory = mutableMapOf<Int, Int>()


    private fun maxBfs(current: Int, relations: Map<Int, MutableList<Int>>, time: IntArray): Int {
        val memorized = memory[current]
        if (memorized != null) return memorized

        val coursesBefore = relations[current] ?: kotlin.run {
            memory[current] = time[current - 1]
            return time[current - 1]
        }

        var max = 0

        for (course in coursesBefore) {
            max = maxOf(max, maxBfs(course, relations, time))
        }

        val result = max + time[current - 1]
        memory[current] = result

        return result
    }
}

fun main(args: Array<String>) {
    val solution = ParallelCourses()
    println(
        solution.minimumTime(
            3,
            arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)),
            intArrayOf(3, 2, 5)
        )
    )

    println(
        solution.minimumTime(
            5, arrayOf(
                intArrayOf(1, 5),
                intArrayOf(2, 5),
                intArrayOf(3, 5),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
            ),
            intArrayOf(1, 2, 3, 4, 5)
        )
    )
}