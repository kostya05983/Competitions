package leetCode.medium

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }

        val result = mutableListOf<IntArray>()
        var start = intervals[0][0]
        var end = intervals[0][1]

        for (i in 1 until intervals.size) {
            if (end < intervals[i][0]) {
                result.add(intArrayOf(start, end))
                start = intervals[i][0]
                end = intervals[i][1]
                continue
            }

            end = maxOf(intervals[i][1], end)
            start = minOf(intervals[i][0], start)
        }
        if (result.isEmpty() || result.last()[1] != end) {
            result.add(intArrayOf(start, end))
        }

        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val solution = MergeIntervals()
    println(
        solution.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))
            .map { it.toList() })
    println(solution.merge(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))).map { it.toList() })
}