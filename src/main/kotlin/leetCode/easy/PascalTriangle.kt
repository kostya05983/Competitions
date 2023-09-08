package leetCode.easy

class PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        result.add(generateRow(emptyList(), 0))
        for (i in 1 until numRows) {
            result.add(generateRow(result[i - 1], i))
        }

        return result
    }

    private fun generateRow(previous: List<Int>, row: Int): List<Int> {
        val result = mutableListOf<Int>()

        for (i in 0..row) {
            if (i == 0 || i == row) {
                result.add(1)
                continue
            }
            val sum = previous[i - 1] + previous[i]
            result.add(sum)
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(PascalTriangle().generate(5))
    println(PascalTriangle().generate(1))
}