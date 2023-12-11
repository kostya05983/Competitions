package leetCode.medium

class IntervalListIntersections {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        var left = 0
        var right = 0

        val result = mutableListOf<IntArray>()
        while (left < firstList.size && right < secondList.size) {
            val leftInterval = firstList[left]
            val rightInterval = secondList[right]

            val start = maxOf(leftInterval[0], rightInterval[0])
            val end = minOf(leftInterval[1], rightInterval[1])
            if (start <= end) {
                result.add(intArrayOf(start, end))
            }

            when {
                leftInterval[1]<rightInterval[1] -> {
                    left++
                }
                leftInterval[1]>rightInterval[1] -> {
                    right++
                }
                else -> {
                    left++
                    right++
                }
            }
        }

        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val solution = IntervalListIntersections()

    println(
        solution.intervalIntersection(
            arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25)),
            arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))
        ).map { it.toList() }
    )

    println(
        solution.intervalIntersection(
            arrayOf(intArrayOf(1, 3), intArrayOf(5, 9)),
            arrayOf()
        ).map { it.toList() }
    )

    println(
        solution.intervalIntersection(
            arrayOf(intArrayOf(3, 10)),
            arrayOf(intArrayOf(5, 10))
        ).map { it.toList() }
    )
}