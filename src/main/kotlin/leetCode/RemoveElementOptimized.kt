package leetCode

class RemoveElementOptimized {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var writePointer = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                nums[writePointer] = nums[i]
                writePointer++
            }
        }
        return writePointer
    }
}

fun main(args: Array<String>) {
    val result = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    val output = RemoveElementOptimized().removeElement(result, 2)
    println(output)
    println(result.toList())
}