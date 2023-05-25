package leetCode.medium

class FriendsOfAppropriateAges {
    fun numFriendRequests(ages: IntArray): Int {
        val ageCounts = IntArray(121)
        for (age in ages) {
            ageCounts[age]++
        }
        var leftBorder = 15
        var result = 0
        var window = 0

        for (age in 15..120) {
            if (age.rem(2) == 0) {
                window -= ageCounts[leftBorder]
                leftBorder++
            }
            val ageCount = ageCounts[age]
            if (ageCount == 0) {
                continue
            }
            window += ageCount
            result += ageCount * (window - 1)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = FriendsOfAppropriateAges()

    val example = solution.numFriendRequests(intArrayOf(16, 16))
    require(example == 2)

    val example1 = solution.numFriendRequests(intArrayOf(16, 17, 18))
    require(example1 == 2)

    val example2 = solution.numFriendRequests(intArrayOf(20, 30, 100, 110, 120))
    require(example2 == 3)

    val example3 = solution.numFriendRequests(intArrayOf(108, 115, 5, 24, 82))
    require(example3 == 3)

    val example4 = solution.numFriendRequests(intArrayOf(118, 14, 7, 63, 103))
    require(example4 == 2)

    val example5 = solution.numFriendRequests(
        intArrayOf(
            81,
            106,
            11,
            66,
            83,
            113,
            51,
            62,
            47,
            42,
            85,
            94,
            78,
            96,
            51,
            14,
            3,
            111,
            57,
            66,
            8,
            113,
            27,
            61,
            21,
            55,
            87,
            15,
            20,
            23,
            14,
            105,
            38,
            85,
            2,
            108,
            103,
            46,
            44,
            27,
            79,
            108,
            106,
            86,
            113,
            24,
            39,
            8,
            7,
            97
        )
    )
    require(example5 == 434)
}