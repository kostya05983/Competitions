package leetCode.medium

class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)
        if (newInterval[1] < intervals[0][0]) return arrayOf(newInterval, *intervals)
        if (newInterval[0] > intervals.last()[1]) return arrayOf(*intervals, newInterval)

        val result = mutableListOf<IntArray>()

        val overlappedIndexes = searchOverlapping(intervals, newInterval)

        val minInterval = overlappedIndexes.firstOrNull()?.let {
            intervals[it][0]
        } ?: newInterval[0]

        val maxInterval = overlappedIndexes.lastOrNull()?.let {
            intervals[it][1]
        } ?: newInterval[1]

        val reformedInterval = intArrayOf(minOf(minInterval, newInterval[0]), maxOf(maxInterval, newInterval[1]))

        var inserted = false
        for (i in intervals.indices) {
            if (overlappedIndexes.contains(i)) {
                if (!inserted) {
                    result.add(reformedInterval)
                    inserted = true
                }
                continue
            }
            result.add(intervals[i])

            if (i != intervals.lastIndex && newInterval[0] > intervals[i][1] && newInterval[1] < intervals[i + 1][0]) {
                result.add(reformedInterval)
            }
        }

        return result.toTypedArray()
    }

    private fun searchOverlapping(intervals: Array<IntArray>, newInterval: IntArray): LinkedHashSet<Int> {
        val overlappedIndexes = LinkedHashSet<Int>()
        for (i in intervals.indices) {
            val interval = intervals[i]
            val (left, right) = interval
            if (left >= newInterval[0] && left <= newInterval[1] || right <= newInterval[1] && right >= newInterval[0]) {
                overlappedIndexes.add(i)
            }
        }
        return overlappedIndexes
    }
}

fun main(args: Array<String>) {
    val solution = InsertInterval()
    println(solution.insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)).toList().map { it.toList() })

    println(
        solution.insert(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 5),
                intArrayOf(6, 7),
                intArrayOf(8, 10),
                intArrayOf(12, 16)
            ), intArrayOf(4, 8)
        ).toList().map { it.toList() })

    println(
        solution.insert(
            arrayOf(intArrayOf(3, 5), intArrayOf(12, 15)), intArrayOf(6, 6)
        ).map { it.toList() }
    )

    println(solution.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(0, 3)).map { it.toList() })
}