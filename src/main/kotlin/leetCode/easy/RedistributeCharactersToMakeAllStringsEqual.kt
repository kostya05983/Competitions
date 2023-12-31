package leetCode.easy

class RedistributeCharactersToMakeAllStringsEqual {
    fun makeEqual(words: Array<String>): Boolean {
        if (words.size == 1) return true

        val frequency = mutableMapOf<Char, Int>()

        for (word in words) {
            for (ch in word) {
                frequency[ch] = frequency.getOrDefault(ch, 0) + 1
            }
        }


        for (entry in frequency) {
            if (entry.value.rem(words.size) != 0) return false
        }

        return true
    }
}

fun main(args: Array<String>) {
    val solution = RedistributeCharactersToMakeAllStringsEqual()
    println(solution.makeEqual(arrayOf("abc", "aabc", "bc")))
    println(solution.makeEqual(arrayOf("ab", "a")))
    println(solution.makeEqual(arrayOf("caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c")))
}