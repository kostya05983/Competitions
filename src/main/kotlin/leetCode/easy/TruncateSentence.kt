package leetCode.easy

class TruncateSentence {
    fun truncateSentence(s: String, k: Int): String {
        val sb = StringBuilder(s.length)
        var count = 0
        for (ch in s) {
            if (ch == ' ') count++
            if (count == k) return sb.toString()
            sb.append(ch)
        }
        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = TruncateSentence()
    val test1 = solution.truncateSentence("Hello how are you Contestant", 4)
    require(test1 == "Hello how are you")

    val test2 = solution.truncateSentence("What is the solution to this problem", 4)
    require(test2 == "What is the solution")

    val test3 = solution.truncateSentence("chopper is not a tanuki", 5)
    require(test3 == "chopper is not a tanuki")
}