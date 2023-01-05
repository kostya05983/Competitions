package leetCode.easy

class ExcelSheetColumnTitle {
    fun convertToTitle(columnNumber: Int): String {
        val result = mutableListOf<Char>()

        var temp = columnNumber
        while (temp > 0) {
            if (temp.rem(26) == 0) {
                result.add('Z')
                temp -= 26
            } else result.add((temp.rem(26) + 64).toChar())

            temp /= 26
        }

        return result.joinToString("").reversed()
    }
}

fun main(args: Array<String>) {
    println(ExcelSheetColumnTitle().convertToTitle(1))
    println(ExcelSheetColumnTitle().convertToTitle(28))
    println(ExcelSheetColumnTitle().convertToTitle(701))
    println(ExcelSheetColumnTitle().convertToTitle(52))
}