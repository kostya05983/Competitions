package leetCode.easy

class MostCommonWord {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val splittedParagraph = paragraph.toLowerCase().split(Regex("[ !?',;.]+"))
        val bannedSet = banned.toSet()

        val frequencies = mutableMapOf<String, Int>()

        for (word in splittedParagraph) {
            if (!bannedSet.contains(word) && word != "") {
                frequencies[word] = frequencies.getOrDefault(word, 0) + 1
            }
        }

        return requireNotNull(frequencies.maxBy { it.value }?.key) { "Max word must exist" }
    }
}

fun main(args: Array<String>) {
    val solution = MostCommonWord()
    val test1 = solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit"))
    require(test1 == "ball")

    val test2 = solution.mostCommonWord("a.", emptyArray())
    require(test2 == "a")

    val test3 = solution.mostCommonWord("..Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit"))
    require(test3 == "ball")
}