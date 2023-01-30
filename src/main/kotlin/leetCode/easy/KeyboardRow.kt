package leetCode.easy

class KeyboardRow {
    private val firstRow = "qwertyuiop"
    private val secondRow = "asdfghjkl"
    private val thirdRow = "zxcvbnm"

    fun findWords(words: Array<String>): Array<String> {
        val result = mutableListOf<String>()
        words.forEach {
            var firstTyped = true
            var secondTyped = true
            var thirdTyped = true
            for (ch in it) {
                val lowerCh = ch.toLowerCase()

                if (lowerCh !in firstRow) {
                    firstTyped = false
                }
                if (lowerCh !in secondRow) {
                    secondTyped = false
                }
                if (lowerCh !in thirdRow) {
                    thirdTyped = false
                }
            }

            if (firstTyped || secondTyped || thirdTyped) {
                result.add(it)
            }
        }

        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val solution = KeyboardRow()
    val test1 = solution.findWords(arrayOf("Hello", "Alaska", "Dad", "Peace"))
    require(test1.contentEquals(arrayOf("Alaska", "Dad")))

    val test2 = solution.findWords(arrayOf("omk"))
    require(test2.contentEquals(arrayOf()))
}