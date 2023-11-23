package leetCode.medium

class ArithmeticSubArrays {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val result = mutableListOf<Boolean>()

        for (i in l.indices) {
            val subArray = nums.sliceArray(l[i]..r[i])
            subArray.sort()
            var prev: Int? = null
            for (j in 0 until subArray.size - 1) {
                val diff = subArray[j + 1] - subArray[j]
                if (prev != null && prev != diff) {
                    result.add(false)
                    break
                }
                prev = diff
            }
            if (result.size <= i) {
                result.add(true)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = ArithmeticSubArrays()
    println(solution.checkArithmeticSubarrays(intArrayOf(4, 6, 5, 9, 3, 7), intArrayOf(0, 0, 2), intArrayOf(2, 3, 5)))
    println(solution.checkArithmeticSubarrays(intArrayOf(-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10), intArrayOf(0,1,6,4,8,7), intArrayOf(4,4,9,7,9,10)))
}