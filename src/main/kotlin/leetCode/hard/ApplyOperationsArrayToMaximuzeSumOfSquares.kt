package leetCode.hard

class ApplyOperationsArrayToMaximuzeSumOfSquares {
    fun maxSum(nums: List<Int>, k: Int): Int {

        nums.sortedBy {
            it.countOneBits()
        }

        TODO()
    }
}

fun main(args: Array<String>) {
    println(5.or(7))
    println(6.or(18))

}