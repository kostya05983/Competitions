package leetCode.easy

class LargestSubstringBetweenTwoEqualCharacters {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val duplicateMap = mutableMapOf<Char, Int>()

        var max = -1
        for (i in s.indices) {
            val ch = s[i]

            val position = duplicateMap[ch]
            if (position != null) {
                max = maxOf(i - position - 1, max)
                continue
            }
            duplicateMap[ch] = i
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = LargestSubstringBetweenTwoEqualCharacters()
    println(solution.maxLengthBetweenEqualCharacters("aa"))
    println(solution.maxLengthBetweenEqualCharacters("abca"))
    println(solution.maxLengthBetweenEqualCharacters("cbzxy"))
    println(solution.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"))
}