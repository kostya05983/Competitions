package leetCode.medium

class MinimumNumberOperationsMakeArray {
    fun minOperations(nums: IntArray): Int {
        val frequencies = mutableMapOf<Int, Int>()
        for (num in nums) {
            frequencies[num] = frequencies.getOrDefault(num, 0) + 1
        }

        val memory = mutableMapOf<Int, Int>()
        var count = 0
        for ((_, value) in frequencies) {
            val memorized = memory[value]
            if (memorized != null) {
                count += memorized
                continue
            }

            var tempCount = 0
            var tempValue = value
            while (tempValue > 4) {
                tempValue -= 3
                tempCount++
            }
            when (tempValue) {
                4 -> {
                    tempCount += 2
                }

                3 -> {
                    tempCount++
                }

                2 -> {
                    tempCount++
                }

                else -> return -1
            }

            count += tempCount
            memory[value] = tempCount
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = MinimumNumberOperationsMakeArray()
    val example1 = solution.minOperations(intArrayOf(2, 3, 3, 2, 2, 4, 2, 3, 4))
    println(example1)

    val example2 = solution.minOperations(intArrayOf(2, 1, 2, 2, 3, 3))
    println(example2)

    val example3 = solution.minOperations(
        intArrayOf(
            1, 1, 1, 1, 1, 1, 1
        )
    )
    println(example3)

    val example4 = solution.minOperations(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1))
    println(example4)

    val example5 = solution.minOperations(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
    println(example5)

    val example6 = solution.minOperations(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
    println(example6)

    val example7 = solution.minOperations(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
    println(example7)

    val example8 = solution.minOperations(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
    println(example8)
}