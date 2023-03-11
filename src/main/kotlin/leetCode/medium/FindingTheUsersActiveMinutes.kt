package leetCode.medium

class FindingTheUsersActiveMinutes {
    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val uamMap = mutableMapOf<Int, MutableSet<Int>>()

        val resultArray = IntArray(k) { 0 }

        for (log in logs) {
            val (id, time) = log
            val uamSet = uamMap.getOrDefault(id, mutableSetOf())
            uamSet.add(time)
            uamMap[id] = uamSet
        }

        for (entry in uamMap) {
            resultArray[entry.value.size - 1]++
        }

        return resultArray
    }
}

fun main(args: Array<String>) {
    val solution = FindingTheUsersActiveMinutes()
    val test1 = solution.findingUsersActiveMinutes(
        arrayOf(
            intArrayOf(0, 5),
            intArrayOf(1, 2),
            intArrayOf(0, 2),
            intArrayOf(0, 5),
            intArrayOf(1, 3)
        ),
        5
    )
    require(test1.contentEquals(intArrayOf(0, 2, 0, 0, 0)))

    val test2 = solution.findingUsersActiveMinutes(
        arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 3)
        ), 4
    )
    require(test2.contentEquals(intArrayOf(1, 1, 0, 0)))
}