package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        var and = nums[0]
        var or = nums[0]
        var xor = nums[0]
        for (i in 1 until nums.size) {
            val value = nums[i]
            and = and.and(value)
            or = or.or(value)
            xor = xor.xor(value)
        }
        println("and=${Integer.toBinaryString(and)} or=${Integer.toBinaryString(or)} xor=${Integer.toBinaryString(xor)}")


        TODO("А дальше не придумали")
    }
}

fun main(args: Array<String>) {
    val solution = FindTheDuplicateNumber()
    assertEquals(2, solution.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
}