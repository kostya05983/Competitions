package leetCode.easy

class PascalTriangle2 {
    fun getRow(rowIndex: Int): List<Int> {
        val result = mutableListOf<List<Int>>()

        for(i in 0..rowIndex) {
            if (i == 0) {
                result.add(generateRow(emptyList(), i))
            } else {
                result.add(generateRow(result[i-1], i))
            }
        }

        return result.last()
    }

    private fun generateRow(previous: List<Int>, row: Int): List<Int> {
        if (row == 0) return listOf(1)
        if (row == 1) return listOf(1, 1)


        val result = mutableListOf<Int>()

        for (i in 0..row - 1) {
            if (i == 0) {
                result.add(1)
                continue
            }
            val sum = previous[i-1] + previous[i]
            result.add(sum)
        }
        result.add(1)

        return result
    }
}

fun main(args: Array<String>) {
    println(PascalTriangle2().getRow(1))
}