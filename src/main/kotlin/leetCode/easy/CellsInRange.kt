package leetCode.easy

class CellsInRange {
    fun cellsInRange(s: String): List<String> {
        val splitted = s.split(":")
        val left = splitted[0]
        val right = splitted[1]

        var leftChar = left[0]
        val leftNumber = left[1]

        val rightChar = right[0]
        val rightNumber = right[1]


        val result = mutableListOf<String>()
        while (leftChar <= rightChar) {
            var temp = leftNumber
            while (temp <= rightNumber) {
                result.add("${leftChar}$temp")
                temp++
            }
            leftChar++
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(CellsInRange().cellsInRange("K1:L2"))
    println(CellsInRange().cellsInRange("A1:F1"))
}