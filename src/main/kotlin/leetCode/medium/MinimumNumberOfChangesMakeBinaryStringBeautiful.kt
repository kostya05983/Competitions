package leetCode.medium

class MinimumNumberOfChangesMakeBinaryStringBeautiful {
    fun minChanges(s: String): Int {
        var result = 0

        for(i in s.indices step 2) {
            if (s[i]!=s[i+1]) {
                result++
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MinimumNumberOfChangesMakeBinaryStringBeautiful()
//    println(solution.minChanges("1001"))
//    println(solution.minChanges("10"))
//    println(solution.minChanges("0000"))
//    println(solution.minChanges("11000111"))
    "0000011001001101"
    println(solution.minChanges("01010000011001001101"))
}