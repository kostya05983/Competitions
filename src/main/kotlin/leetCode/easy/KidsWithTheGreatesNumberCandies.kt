package leetCode.easy

class KidsWithTheGreatesNumberCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.max()!!

        val result = mutableListOf<Boolean>()
        for (element in candies) {
            result.add((element + extraCandies) >= max)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = KidsWithTheGreatesNumberCandies()
    val example1 = solution.kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3)
    println(example1)

    val example2 = solution.kidsWithCandies(intArrayOf(4, 2, 1, 1, 2), 1)
    println(example2)

    val example3 = solution.kidsWithCandies(intArrayOf(12, 1, 12), 10)
    println(example3)
}