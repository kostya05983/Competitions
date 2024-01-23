package leetCode.medium

class MaximumLengthConcatenatedUniqueCharacters {
    fun maxLength(arr: List<String>): Int {
        val result = mutableListOf<String>()
        result.add("")
        var maxLength = 0
        for (chunk in arr) {
            for (i in 0 until result.size) {
                val newResult = result[i] + chunk
                val newResultSet = newResult.toHashSet()

                if (newResult.length != newResultSet.size) continue

                result.add(newResult)
                maxLength = maxOf(maxLength, newResult.length)
            }
        }

        return maxLength
    }
}

fun main(args: Array<String>) {
    val solution = MaximumLengthConcatenatedUniqueCharacters()
    println(solution.maxLength(listOf("un", "iq", "ue")))
    println(solution.maxLength(listOf("cha", "r", "act", "ers")))
    println(solution.maxLength(listOf("abcdefghijklmnopqrstuvwxyz")))
}