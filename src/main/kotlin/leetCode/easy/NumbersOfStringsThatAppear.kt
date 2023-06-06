package leetCode.easy

class NumbersOfStringsThatAppear {
    fun numOfStrings(patterns: Array<String>, word: String): Int {
        return patterns.count {
            word.contains(it)
        }
    }
}

fun main(args: Array<String>) {
    val solution = NumbersOfStringsThatAppear()
    val example1 = solution.numOfStrings(arrayOf("a", "abc", "bc", "d"), "abc")
    require(example1 == 3)
}