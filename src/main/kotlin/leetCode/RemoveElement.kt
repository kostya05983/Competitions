package leetCode

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var currentSize = nums.size
        var i = 0
        while (i < currentSize) {
            if (nums[i] == `val`) {
                currentSize--
                leftShiftFrom(i, nums)
            }
            if (nums[i]!=`val`) {
                i++
            }

        }
        return currentSize
    }

    fun leftShiftFrom(position: Int, nums: IntArray) {
        var current = position
        while (current < nums.size - 1) {
            nums[current] = nums[current + 1]
            current++
        }
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(0,1,2,2,3,0,4,2)
    val result = RemoveElement().removeElement(array, 2)
    println(result)
    println(array.toList())
}