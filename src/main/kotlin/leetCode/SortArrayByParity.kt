package leetCode

class SortArrayByParity {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var writePointer = 0
        for (i in nums.indices) {
            if (nums[i].rem(2) == 0) {
                val swap = nums[writePointer]
                nums[writePointer] = nums[i]
                nums[i] = swap
                writePointer++
            }
        }
        return nums
    }
}

fun main(args: Array<String>) {
    println(SortArrayByParity().sortArrayByParity(intArrayOf(0)).toList())
}