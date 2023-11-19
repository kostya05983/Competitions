package leetCode.easy

class Contest {
    fun findMinimumOperations(s1: String, s2: String, s3: String): Int {
        if (s1[0] != s2[0] || s2[0] != s3[0] || s1[0] != s3[0]) return -1


        val sb1 = StringBuilder(s1.length)
        sb1.append(s1)
        val sb2 = StringBuilder(s2.length)
        sb2.append(s2)
        val sb3 = StringBuilder(s3.length)
        sb3.append(s3)

        var count = 0
        while (sb1.toString() != sb2.toString() || sb2.toString() != sb3.toString()) {
            if (sb1.length != sb2.length || sb2.length != sb3.length) {
                val minLength = minOf(sb1.length, sb2.length, sb3.length)

                count += (sb1.length - minLength)
                count += (sb2.length - minLength)
                count += (sb3.length - minLength)

                sb1.setLength(minLength)
                sb2.setLength(minLength)
                sb3.setLength(minLength)
            } else {
                sb1.setLength(sb1.length - 1)
                sb2.setLength(sb2.length - 1)
                sb3.setLength(sb3.length - 1)
                count += 3
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = Contest()
//    println(solution.findMinimumOperations("abc", "abb", "ab"))
//    println(solution.findMinimumOperations("dac", "bac", "cac"))
    println(solution.findMinimumOperations("nksgoidx", "nkscbvw", "nksfr"))
}