package leetCode.easy

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var counter = 0
        var majorityElement = 0
        for (i in 0 until nums.size) {
            val number = nums[i]
            if (counter == 0) {
                majorityElement = number
                counter++
                continue
            }

            if (number == majorityElement) {
                counter++
            } else {
                counter--
            }
        }

        return majorityElement
    }
}

fun main(args: Array<String>) {
    println(MajorityElement().majorityElement(intArrayOf(3, 2, 3)))
    println(MajorityElement().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    println(MajorityElement().majorityElement(intArrayOf(2, 1, 2, 1, 2, 2)))
}