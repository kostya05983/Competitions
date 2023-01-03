package leetCode.easy

class DeleteColumns {
    fun minDeletionSize(strs: Array<String>): Int {
        var count = 0

        if (strs.isEmpty()) return 0

        val amountColumns = strs[0].length
        val columnsStr = Array(amountColumns) { "" }
        for (i in 0 until amountColumns) {
            for (element in strs) {
                columnsStr[i] = columnsStr[i] + element[i]
            }
        }

        for (column in columnsStr) {
            var ascendant = true
            for (i in 0 until column.length - 1) {
                if (column[i] > column[i + 1]) {
                    ascendant = false
                }
            }
            if (!ascendant) {
                count++
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(DeleteColumns().minDeletionSize(arrayOf("abc", "bce", "cae")))
    println(DeleteColumns().minDeletionSize(arrayOf("cba", "daf", "ghi")))
    println(DeleteColumns().minDeletionSize(arrayOf("a", "b")))
    println(DeleteColumns().minDeletionSize(arrayOf("zyx", "wvu", "tsr")))
}