package leetCode.medium

class MaxNumberKSumPairs {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val hashMap = HashMap<Int, Int>()
        for (num in nums) {
            hashMap[num] = hashMap.getOrDefault(num, 0) + 1
        }

        var result = 0
        var i = 0
        while (i < nums.size) {
            if (hashMap[nums[i]] == 0) {
                i++
                continue
            }

            val other = k - nums[i]

            hashMap[nums[i]] = hashMap[nums[i]]!! - 1

            val otherFrequency = hashMap[other]
            if (otherFrequency == null || otherFrequency == 0) {
                i++
                continue
            }
            hashMap[other] = otherFrequency - 1
            result++
            i++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MaxNumberKSumPairs()
    println(solution.maxOperations(intArrayOf(1, 2, 3, 4), 5))
    println(solution.maxOperations(intArrayOf(3, 1, 3, 4, 3), 6))
}