package leetCode.easy

class SortTheSentence {
    fun sortSentence(s: String): String {
        return s.split(" ").sortedBy {
            it.find { it.isDigit() }
        }.joinToString(" ") { it.dropLast(1) }
    }
}

fun main(args: Array<String>) {
    val solution = SortTheSentence()
    val test1 = solution.sortSentence("is2 sentence4 This1 a3")
    require(test1 == "This is a sentence") { test1 }
}