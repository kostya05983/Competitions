package leetCode.easy

class DetectCapital {
    fun detectCapitalUse(word: String): Boolean {
        var capitalLettersCount = 0
        var lowerLettersCount = 0

        for (ch in word) {
            if (ch.isUpperCase()) {
                capitalLettersCount++
            } else {
                lowerLettersCount++
            }
        }

        return capitalLettersCount == word.length || lowerLettersCount == word.length || lowerLettersCount == word.length - 1 && capitalLettersCount == 1 && word[0].isUpperCase()
    }
}

fun main(args: Array<String>) {
    val solution = DetectCapital()
    val test1 = solution.detectCapitalUse("USA")
    require(test1)

    val test2 = solution.detectCapitalUse("FlaG")
    require(!test2)

    val test3 = solution.detectCapitalUse("leetcode")
    require(test3)

    val test4 = solution.detectCapitalUse("Google")
    require(test4)
}