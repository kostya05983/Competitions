package leetCode.medium

import kotlin.math.floor
import kotlin.math.log2

class MaximumXorOfTwoNumbersInArray {
    fun findMaximumXOR(nums: IntArray): Int {
        val groups = Array(32) { mutableListOf<Int>() }

        for (num in nums) {
            groups[log2(num.toDouble()).toInt() + 1].add(num)
        }
        println(groups)

        //Взять число из наибольшей группы, найти где у него первый нолик, перебирать числа в группе, где этот нолик

        TODO()
    }
}

//1000000
//0111110
//
//000000001
//110000000

//1) Два максимально не похожих друг на друга числа
//2) И чем они больше, тем лучше
fun main(args: Array<String>) {
    val solution = MaximumXorOfTwoNumbersInArray()
    val example1 = solution.findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8))
    require(example1 == 28)

//    for (i in 1..1000) {
//        for (j in 1..1000) {
//
//            println("xor for ${i} ${j} ${i.xor(j)}")
//        }
//    }
}