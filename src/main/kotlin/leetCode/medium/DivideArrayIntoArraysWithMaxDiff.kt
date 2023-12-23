package leetCode.medium

class DivideArrayIntoArraysWithMaxDiff {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        nums.sort()

        val result = Array(nums.size / 3) { IntArray(3) }

        for (i in 0 until nums.size step 3) {

            if (nums[i + 2] - nums[i] > k || nums[i + 2] - nums[i + 1] > k
                || nums[i + 1] - nums[i] > k
            ) return emptyArray()
            val index = i/3
            result[index][0] = nums[i]
            result[index][1] = nums[i+1]
            result[index][2] = nums[i+2]
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = DivideArrayIntoArraysWithMaxDiff()
    println(solution.divideArray(intArrayOf(1,3,4,8,7,9,3,5,1),2).map {
        it.toList()
    })
    println(solution.divideArray(intArrayOf(1,3,3,2,7,3),3).map { it.toList() })
}