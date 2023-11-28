package leetCode.easy

class FindWordsContainingCharacter {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val result = mutableListOf<Int>()

        for (i in words.indices) {
            val word = words[i]
            if (word.any { it == x }) {
                result.add(i)
            }
        }

        return result
    }
}