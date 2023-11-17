package leetCode.medium

class SortIntegersByPowerValue {
    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val dp = HashMap<Int, Int>()

        for (i in lo..hi) {
            var current = i
            var count = 0
            while (current != 1) {
                val memorized = dp[current - 1]
                if (memorized != null) {
                    count += memorized
                    break
                }

                count++
                current = if (current.rem(2) == 0) {
                    current / 2
                } else {
                    current * 3 + 1
                }
            }
            dp[i - 1] = count
        }

        val result = mutableListOf<Int>()
        for (i in lo..hi) {
            result.add(i)
        }

        result.sortWith { o1, o2 ->
            val count1 = dp[o1 - 1]!!
            val count2 = dp[o2 - 1]!!
            if (count1 == count2) {
                o1.compareTo(o2)
            } else {
                count1.compareTo(count2)
            }
        }

        return result[k - 1]
    }

}

fun main(args: Array<String>) {
    val solution = SortIntegersByPowerValue()
    println(solution.getKth(12, 15, 2))
    println(solution.getKth(7, 11, 4))
}