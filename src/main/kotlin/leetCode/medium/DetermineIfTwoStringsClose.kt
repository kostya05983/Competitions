package leetCode.medium

class DetermineIfTwoStringsClose {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val wordFrequencies = getFrequencies(word1)
        val otherWordFrequencies = getFrequencies(word2)

        for (entry in wordFrequencies) {
            otherWordFrequencies[entry.key] ?: return false
        }

        val reverseWordFrequencies = reverseFrequencies(wordFrequencies)

        val reverseOtherWordFrequencies = reverseFrequencies(otherWordFrequencies)

        for (entry in reverseWordFrequencies) {
            val otherWordFrequency = reverseOtherWordFrequencies[entry.key]
            if (entry.value != otherWordFrequency) return false
        }

        return true
    }

    private fun reverseFrequencies(frequencies: Map<Char, Int>): HashMap<Int, Int> {
        val reverseFrequencies = HashMap<Int, Int>()

        for (entry in frequencies) {
            reverseFrequencies[entry.value] = reverseFrequencies.getOrDefault(entry.value, 0) + 1
        }

        return reverseFrequencies
    }

    private fun getFrequencies(word: String): Map<Char, Int> {
        val frequencies = HashMap<Char, Int>()
        for (ch in word) {
            frequencies[ch] = frequencies.getOrDefault(ch, 0) + 1
        }

        return frequencies
    }
}

fun main(args: Array<String>) {
    val solution = DetermineIfTwoStringsClose()
    println(solution.closeStrings("abc", "bca"))
    println(solution.closeStrings("a", "aa"))
    println(solution.closeStrings("cabbba", "abbccc"))
}