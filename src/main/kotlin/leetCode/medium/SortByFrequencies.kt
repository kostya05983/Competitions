package leetCode.medium

class SortByFrequencies {
    fun frequencySort(s: String): String {
        val frequencies = mutableMapOf<Char, Int>()

        for (ch in s) {
            frequencies[ch] = frequencies.getOrDefault(ch, 0) + 1
        }

        val sb = StringBuilder()

        val frequenciesList = frequencies.toList().sortedByDescending { it.second }

        for (entry in frequenciesList) {
            for (i in 0 until entry.second) {
                sb.append(entry.first)
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = SortByFrequencies()
    println(solution.frequencySort("loveleetcode"))
}