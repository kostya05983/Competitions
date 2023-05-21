package leetCode.easy

class RemoveDuplicatesInPlace {
    fun removeDuplicates(nums: IntArray): Int {
        var uniqueElements = 1
        for (i in 0 until nums.size - 1) {
            if (nums[i] != nums[i + 1]) {
                nums[uniqueElements] = nums[i + 1]
                uniqueElements++
            }
        }
        return uniqueElements
    }
}

fun main(args: Array<String>) {
    val result = intArrayOf(1,2)
    println(RemoveDuplicatesInPlace().removeDuplicates(result))
    println(result.toList())
}