package leetCode.easy

class FindTheTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (trust.isEmpty() && n == 1) return 1

        val frequencies = mutableMapOf<Int, Int>()
        val frequenciesLeft = mutableMapOf<Int, Int>()
        for (item in trust) {
            val left = item[0]
            val right = item[1]
            frequencies[right] = frequencies.getOrDefault(right, 0) + 1
            frequenciesLeft[left] = frequenciesLeft.getOrDefault(left, 0) + 1
        }

        val max = frequencies.maxBy { it.value } ?: return -1

        val trustNobody = frequenciesLeft[max.key]

        return if (trustNobody == null && max.value == n - 1) {
            max.key
        } else {
            -1
        }
    }
}

fun main(args: Array<String>) {
    println(FindTheTownJudge().findJudge(2, arrayOf(intArrayOf(1, 2))))
    println(FindTheTownJudge().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))))
    println(FindTheTownJudge().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1))))
    println(FindTheTownJudge().findJudge(4, arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 3))))
    println(
        FindTheTownJudge().findJudge(
            4,
            arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(4, 3))
        )
    )
}