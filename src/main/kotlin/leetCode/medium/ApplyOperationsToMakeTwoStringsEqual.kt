package leetCode.medium


class ApplyOperationsToMakeTwoStringsEqual {
    fun minOperations(s1: String, s2: String, x: Int): Int {
        val sb = StringBuilder(s1)

        var diff = 0
        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                diff++
            }
        }
        if (diff.rem(2) != 0) return -1

        var diffCount = 0

        var count = 0
        for (i in 0 until sb.length - 1) {
            val revertI = revert(sb[i])
            val revertI1 = revert(sb[i + 1])

            if (sb[i] == s2[i]) continue
            if (revertI == s2[i] && revertI1 == s2[i + 1]) {
                sb[i] = s2[i]
                sb[i + 1] = s2[i + 1]
                count++
                continue
            }
            if ((revertI == s2[i] || revertI1 == s2[i + 1]) && !(s2[i + 1] == sb[i] && s2[i] == sb[i + 1])) {
                sb[i] = revertI
                sb[i + 1] = revertI1
                count++
                continue
            }
            diffCount++

            if (i == sb.lastIndex - 1) {
                if (sb.last() != s2.last()) diffCount++
            }
        }

        count += (diffCount / 2) * x

        return count
    }

    private fun revert(ch: Char): Char {
        return if (ch == '0') return '1'
        else '0'
    }
}

fun main(args: Array<String>) {
    val solution = ApplyOperationsToMakeTwoStringsEqual()
    println(solution.minOperations("1100011000", "0101001010", 2))
    println(solution.minOperations("10110", "00011", 4))
    println(solution.minOperations("1000000000", "1000100001", 2))
    println(solution.minOperations("101101", "000000", 6))
}