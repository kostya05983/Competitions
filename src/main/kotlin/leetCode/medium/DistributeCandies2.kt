package leetCode.medium

class DistributeCandies2 {
    fun distributeCandies(n: Int, limit: Int): Long {
        var result = 0L

        var i = 0
        while (i <= limit && i <= n) {
            val remainCandies = n - i

            if (remainCandies > 2 * limit) {
                i++
                continue
            }

            val min = maxOf(0, remainCandies - limit)
            val max = minOf(remainCandies, limit)

            result += maxOf(max - min + 1)

            i++
        }

        return result
    }
}