package leetCode.medium

class FindTheOriginalArrayPrefixXor {
    fun findArray(pref: IntArray): IntArray {
        val result = IntArray(pref.size)
        result[0] = pref[0]

        var current = result[0]
        for (i in 1 until pref.size) {
            result[i] = current.xor(pref[i])
            current = current.xor(result[i])
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = FindTheOriginalArrayPrefixXor()
    val example1 = solution.findArray(intArrayOf(5, 2, 0, 3, 1))
    println(example1.toList())

    val example2 = solution.findArray(intArrayOf(13))
    println(example2.toList())
}