package leetCode.medium

class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()


        var newLeft = newInterval[0]
        var newRight = newInterval[1]

        var i = 0
        while (i < intervals.size) {
            var currentInterval = intervals[i]
            var nextInterval = intervals.getOrNull(i + 1)
            var right = -1

            if (newLeft!=-1 && (newLeft < currentInterval[0] && newLeft != currentInterval[0] - 1)) {
                //проверяем правый
                var temp = currentInterval
                while (newRight > temp[1]) {
                    i++
                    temp = intervals[i]
                }
                right = if (newRight > temp[0]) {
                    temp[1]
                } else {
                    newRight
                }

                result.add(intArrayOf(newLeft, right))
                newLeft = -1
                newRight = -1
                continue
            }

            if (newLeft!=-1 && (newLeft <= currentInterval[1] || currentInterval[1] + 1 == newLeft)) {
                //проверяем правый
                var temp = currentInterval
                while (newRight > temp[1]) {
                    i++
                    temp = intervals[i]
                }
                right = if (newRight > temp[0]) {
                    temp[1]
                } else {
                    newRight
                }

                result.add(intArrayOf(currentInterval[0], right))
                newLeft = -1
                newRight = -1
                continue
            }

            if (nextInterval != null && currentInterval[1] < newLeft && nextInterval[0] > newRight) {
                result.add(intArrayOf(newLeft, newRight))
            }

            result.add(currentInterval)
            i++
        }

        return result.toTypedArray()
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
}