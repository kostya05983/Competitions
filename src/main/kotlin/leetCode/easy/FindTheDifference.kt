package leetCode.easy

class FindTheDifference {
    fun findTheDifference(s: String, t: String): Char {
        val frequencies = mutableMapOf<Char, Int>()
        for (ch in s) {
            frequencies[ch] = frequencies.getOrDefault(ch, 0) + 1
        }

        val secondFrequencies = mutableMapOf<Char, Int>()
        for (ch in t) {
            if (!frequencies.contains(ch)) return ch
            secondFrequencies[ch] = secondFrequencies.getOrDefault(ch, 0) + 1
        }

        for (entry in secondFrequencies) {
            val originalValue = frequencies[entry.key]
            if (originalValue != entry.value) return entry.key
        }

        throw IllegalArgumentException("No diff")
    }
}

fun main(args: Array<String>) {
    println(FindTheDifference().findTheDifference("abcd", "abcde"))
    println(FindTheDifference().findTheDifference("", "y"))
    println(FindTheDifference().findTheDifference("a", "aa"))
}