package leetCode.medium

class NumberOfPairInterchangeable {
    fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
        val frequency = mutableMapOf<Double, Int>()
        var count = 0L
        for ((width, height) in rectangles) {
            val ratio = width / height.toDouble()

            val newValue = frequency.getOrDefault(ratio, 0) + 1

            frequency[ratio] = newValue

            if (newValue != 1) {
                count += newValue - 1
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfPairInterchangeable()
    println(
        solution.interchangeableRectangles(
            arrayOf(
                intArrayOf(4, 8),
                intArrayOf(3, 6),
                intArrayOf(10, 20),
                intArrayOf(15, 30)
            )
        )
    )
}