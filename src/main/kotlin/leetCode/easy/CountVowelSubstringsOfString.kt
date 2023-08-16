package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CountVowelSubstringsOfString {
    private val vowelSet = setOf(
        'a', 'e', 'i', 'o', 'u'
    )

    fun countVowelSubstrings(word: String): Int {
        var result = 0

        var left = 0
        var right: Int

        while (left < word.length) {
            val ch = word[left]
            val windowSet = mutableSetOf<Char>()
            if (ch !in vowelSet) {
                left++
                continue
            }

            right = left
            while (right < word.length && word[right] in vowelSet) {
                windowSet.add(word[right])
                right++
                if (windowSet.size == vowelSet.size) {
                    result += 1
                }
            }
            left++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = CountVowelSubstringsOfString()
    val example1 = solution.countVowelSubstrings("aeiouu")
    assertEquals(2, example1)

    val example2 = solution.countVowelSubstrings("unicornarihan")
    assertEquals(0, example2)

    val example3 = solution.countVowelSubstrings("cuaieuouac")
    assertEquals(7, example3)
}