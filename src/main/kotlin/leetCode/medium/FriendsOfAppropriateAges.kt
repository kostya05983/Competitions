package leetCode.medium

class FriendsOfAppropriateAges {
    fun numFriendRequests(ages: IntArray): Int {
        var count = 0
        for (i in 0 until ages.size) {
            val origin = ages[i]

            for (j in 0 until ages.size) {
                if (i == j) continue
                val target = ages[j]

                if (isMatch(target, origin)) {
                    count++
                }
                if (isMatch(target, origin)) {
                    count++
                }
            }

        }

        return count
    }

    fun isMatch(target: Int, origin: Int): Boolean {
        if (target <= origin.shr(1) + 7) {
            return false
        }
        if (target > origin) return false
        if (target > 100 && origin < 100) return false
        return true
    }
}

fun main(args: Array<String>) {
    val solution = FriendsOfAppropriateAges()

//    val example = solution.numFriendRequests(intArrayOf(16, 16))
//    require(example == 2)
//
//    val example1 = solution.numFriendRequests(intArrayOf(16, 17, 18))
//    require(example1 == 2)
//
//    val example2 = solution.numFriendRequests(intArrayOf(20, 30, 100, 110, 120))
//    require(example2 == 3)

    for (i in 1..120) {
        for (j in i downTo 1) {
            if (!solution.isMatch(i, j)) {
                println("Диапазон ${i}..$j")
                break
            }
        }
    }

}