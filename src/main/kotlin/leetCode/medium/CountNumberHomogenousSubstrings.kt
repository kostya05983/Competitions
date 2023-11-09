package leetCode.medium

class CountNumberHomogenousSubstrings {
    fun countHomogenous(s: String): Int {
        var left = 0
        var right = 1
        var count = 0L
        val mod = 1_000_000_007

        while (left < s.length || right < s.length) {
            if (right < s.length && s[right] == s[right - 1]) {
                right++
                continue
            }
            val substringLength = right - left
            count += substringLength.toLong() * (substringLength + 1) / 2

            left = right
            right++
        }

        return count.rem(mod).toInt()
    }
}

fun main(args: Array<String>) {
    val solution = CountNumberHomogenousSubstrings()
    println(solution.countHomogenous("abbcccaa"))
    println(solution.countHomogenous("xy"))
    println(solution.countHomogenous("zzzzz"))
}