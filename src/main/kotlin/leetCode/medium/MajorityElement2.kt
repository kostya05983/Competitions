package leetCode.medium

class MajorityElement2 {
    fun majorityElement(nums: IntArray): List<Int> {
        val frequency = mutableMapOf<Int, Int>()

        val count = nums.size / 3 + 1
        val result = mutableListOf<Int>()
        for (num in nums) {
            val newValue = frequency.getOrDefault(num, 0) + 1
            frequency[num] = newValue

            if (newValue == count) {
                result.add(num)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {

}