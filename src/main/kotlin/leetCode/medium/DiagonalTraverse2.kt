package leetCode.medium

class DiagonalTraverse2 {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val result = mutableListOf<Triple<Int, Int, Int>>()
        for (i in nums.indices) {
            for (j in 0 until nums[i].size) {
                result.add(Triple(i + j, i, nums[i][j]))
            }
        }

        result.sortWith { o1, o2 ->
            if (o1.first == o2.first) {
                o2.second.compareTo(o1.second)
            } else {
                o1.first.compareTo(o2.first)
            }
        }

        return result.map { it.third }.toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution = DiagonalTraverse2()
    println(solution.findDiagonalOrder(listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))).toList())
    println(
        solution.findDiagonalOrder(
            listOf(
                listOf(1, 2, 3, 4, 5),
                listOf(6, 7),
                listOf(8),
                listOf(9, 10, 11),
                listOf(12, 13, 14, 15, 16)
            )
        ).toList()
    )
}