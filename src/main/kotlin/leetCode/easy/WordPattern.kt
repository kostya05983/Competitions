package leetCode.easy

class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val splitted = s.split(" ")
        val patternToWord = hashMapOf<Char, String>()
        val wordToPattern = hashMapOf<String, Char>()


        if (splitted.size != pattern.length) return false

        for (i in pattern.indices) {
            val ch = pattern[i]
            val word = splitted[i]

            val foundWord = patternToWord[ch]
            if (foundWord != null && foundWord != word) return false

            val foundPattern = wordToPattern[word]
            if (foundPattern != null && foundPattern != ch) return false

            patternToWord[ch] = word
            wordToPattern[word] = ch
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution = WordPattern()
    val test1 = solution.wordPattern("abba", "dog cat cat dog")
    require(test1)

    val test2 = solution.wordPattern("abba", "dog cat cat fish")
    require(!test2)

    val test3 = solution.wordPattern("aaaa", "dog cat cat dog")
    require(!test3)

    val test4 = solution.wordPattern("aa", "dog cat dog")
    require(!test4)

    val test5 = solution.wordPattern("aaa", "dog cat")
    require(!test5)

    val test6 = solution.wordPattern("aaaa", "dog dog dog dog")
    require(test6)

    val test7 = solution.wordPattern("abba", "dog dog dog dog")
    require(!test7)
}