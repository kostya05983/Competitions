package leetCode.medium

class CountSortedVowelStrings {

    fun countVowelStrings(n: Int): Int {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24
    }
}