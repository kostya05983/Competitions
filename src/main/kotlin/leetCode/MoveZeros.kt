package leetCode

class MoveZeros {
    fun moveZeroes(nums: IntArray): Unit {
        var writePointer = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[writePointer] = nums[i]
                if (writePointer != i) {
                    nums[i] = 0
                }
                writePointer++
            }
        }
    }
}

fun main(args: Array<String>) {
    val result = intArrayOf(1)
    MoveZeros().moveZeroes(result)
    println(result.toList())
}