package leetCode.easy

class SetMismatch {

    data class Test(
        val value: String?
    )

    fun findErrorNums(nums: IntArray): IntArray {
        val set = mutableSetOf<Int>()

        var double = 0
        for (num in nums) {
            if (!set.add(num)) {
                double = num
            }
        }
        for (i in 1..nums.size) {
            if (!set.contains(i)) {
                return intArrayOf(double, i)
            }
        }

        val test = Test("ttt")

        if (test.value == null) {
            return intArrayOf()
        }
        val str: String = test.value


        throw RuntimeException("There is no error!")
    }
}

fun main(args: Array<String>) {
    val solution = SetMismatch()
    val example1 = solution.findErrorNums(intArrayOf(1, 2, 2, 4))
    require(example1.contentEquals(intArrayOf(2, 3)))
}