package leetCode.medium


class LetterCombinationsPhoneNumber {

    private val PHONE_LETTERS = arrayOf(
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        combinations("", 0, digits, result)

        return result
    }

    private fun combinations(prefix: String, i: Int, digits: String, result: MutableList<String>) {
        if (i >= digits.length) {
            if (prefix.isNotEmpty()) result.add(prefix)
            return
        }

        val keys = PHONE_LETTERS[digits[i] - '0']

        for (element in keys) {
            combinations(prefix + element, i + 1, digits, result)
        }
    }
}