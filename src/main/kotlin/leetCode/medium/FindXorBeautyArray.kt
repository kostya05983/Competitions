package leetCode.medium

class FindXorBeautyArray {
    fun xorBeauty(nums: IntArray): Int {
        var xor = nums[0]

        for(i in 1 until nums.size) {
            val num = nums[i]
            xor = xor.xor(num)
        }
        return xor
    }
}

fun main(args: Array<String>) {
    val solution = FindXorBeautyArray()
    val example1 = solution.xorBeauty(intArrayOf(15,45,20,2,34,35,5,44,32,30))
    println(example1)
    println(1 xor 4)
}