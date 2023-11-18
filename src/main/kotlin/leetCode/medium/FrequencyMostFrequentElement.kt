package leetCode.medium

class FrequencyMostFrequentElement {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        var i = 0
        var maxFrequency = 1

        nums.sort()
        while (i < nums.size) {
            var frequency = 1
            while (i < nums.size - 1 && nums[i + 1] - nums[i] == 0) {
                i++
                frequency++
            }

            var remainK = k
            var left = i - 1
            while (remainK > 0 && left >= 0) {
                val leftNum = nums[left]

                remainK -= (nums[i] - leftNum)
                if (remainK < 0) break
                left--

                if (nums[i] - leftNum == 0) continue
                frequency++
            }

            maxFrequency = maxOf(maxFrequency, frequency)
            i++
        }

        return maxFrequency
    }
}

fun main(args: Array<String>) {
    val solution = FrequencyMostFrequentElement()
    println(solution.maxFrequency(intArrayOf(1, 2, 4), 5))
    println(solution.maxFrequency(intArrayOf(1, 4, 8, 13), 5))
    println(solution.maxFrequency(intArrayOf(3, 9, 6), 2))
    println(solution.maxFrequency(intArrayOf(1, 1, 1, 1, 2, 4), 5))
    println(solution.maxFrequency(intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 4, 5, 6, 7, 8, 3, 3, 3, 3, 3, 3), 5))
}