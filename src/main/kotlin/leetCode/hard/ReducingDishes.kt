package leetCode.hard

class ReducingDishes {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sort()
        val memory = Array(satisfaction.size + 1) { IntArray(satisfaction.size + 1) { -1 } }

        return handle(1, 0, satisfaction, memory)
    }

    private fun handle(time: Int, index: Int, satisfaction: IntArray, memory: Array<IntArray>): Int {
        if (index == satisfaction.size) {
            return 0
        }

        if (memory[index][time] != -1) {
            return memory[index][time]
        }

        val cook = satisfaction[index] * time + handle(
            time + 1,
            index + 1,
            satisfaction,
            memory
        )
        val notCooked = handle(time, index + 1, satisfaction, memory)

        val max = maxOf(cook, notCooked)
        memory[index][time] = max

        return max
    }
}

fun main(args: Array<String>) {
    val solution = ReducingDishes()
    println(solution.maxSatisfaction(intArrayOf(-1, -8, 0, 5, -9)))
    println(solution.maxSatisfaction(intArrayOf(4, 3, 2)))
    println(solution.maxSatisfaction(intArrayOf(-1, -4, -5)))
}