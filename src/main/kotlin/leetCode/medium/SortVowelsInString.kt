package leetCode.medium

class SortVowelsInString {
    private val vowels = setOf('a', 'e', 'i', 'o', 'u')

    fun sortVowels(s: String): String {
        val sb = StringBuilder(s)

        val tempVowels = mutableListOf<Char>()
        for (ch in sb) {
            if (vowels.contains(ch.lowercaseChar())) tempVowels.add(ch)
        }

        tempVowels.sort()

        var index = 0
        for (i in sb.indices) {
            if (vowels.contains(sb[i].lowercaseChar())) {
                sb[i] = tempVowels[index]
                index++
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = SortVowelsInString()
    println(solution.sortVowels("lEetcOde"))
    println(solution.sortVowels("lYmpH"))
}