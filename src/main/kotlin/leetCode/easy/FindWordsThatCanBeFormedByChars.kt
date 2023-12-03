package leetCode.easy

class FindWordsThatCanBeFormedByChars {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val frequency = mutableMapOf<Char, Int>()

        for (char in chars) {
            frequency[char] = frequency.getOrDefault(char, 0) + 1
        }

        var result = 0
        for(word in words) {
            val copy = frequency.toMutableMap()

            val isGood = isGood(word, copy)
            if (isGood) result+=word.length
        }

        return result
    }

    private fun isGood(word: String, frequency: MutableMap<Char, Int>): Boolean {
        for(ch in word) {
            val found = frequency[ch]
            if (found == null) return false
            if (found == 0) return false
            frequency[ch] = found-1
        }

        return true
    }
}