package leetCode

class FindAllNumbersDisapperedInArray {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        var i = 0
        var writePointer = 0
        var temp = nums[0]
        while (i < nums.size) {
            var index = temp - 1
            while (i < nums.size && (index >= 0 && nums[index] == -1 || nums[i] == -1)) {
                i++
                if (i < nums.size) {
                    index = nums[i] - 1
                }

            }
            if (index >= 0) {
                temp = nums[index]
                nums[index] = -1
            }

            while (temp == -1 && i < nums.size) {
                temp = nums[i]
                if (temp != -1) {
                    break
                }
                i++
            }
        }


        for (j in nums.indices) {
            if (nums[j] != -1) {
                nums[writePointer] = j + 1
                writePointer++
            }
        }

        return nums.toList().subList(0, writePointer)
    }
}

fun main(args: Array<String>) {
    println(FindAllNumbersDisapperedInArray().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
}