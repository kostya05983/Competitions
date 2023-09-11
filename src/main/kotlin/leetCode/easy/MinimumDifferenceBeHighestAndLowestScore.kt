package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MinimumDifferenceBeHighestAndLowestScore {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        if (nums.size == 1 && k == 1) return 0

        nums.sortDescending()

        var i = k - 1
        var min = Int.MAX_VALUE
        while (i < nums.size) {
            min = minOf(min, nums[i - k + 1] - nums[i])
            i++
        }

        return min
    }
}

fun main(args: Array<String>) {
    val solution = MinimumDifferenceBeHighestAndLowestScore()
    val example1 = solution.minimumDifference(intArrayOf(90), 1)
    assertEquals(0, example1)

    val example2 = solution.minimumDifference(intArrayOf(9, 4, 1, 7), 2)
    assertEquals(2, example2)

    val example3 = solution.minimumDifference(intArrayOf(87063, 61094, 44530, 21297, 95857, 93551, 9918), 6)
    assertEquals(74560, example3)

    val example4 = solution.minimumDifference(
        intArrayOf(
            41900,
            69441,
            94407,
            37498,
            20299,
            10856,
            36221,
            2231,
            54526,
            79072,
            84309,
            76765,
            92282,
            13401,
            44698,
            17586,
            98455,
            47895,
            98889,
            65298,
            32271,
            23801,
            83153,
            12186,
            7453,
            79460,
            67209,
            54576,
            87785,
            47738,
            40750,
            31265,
            77990,
            93502,
            50364,
            75098,
            11712,
            80013,
            24193,
            35209,
            56300,
            85735,
            3590,
            24858,
            6780,
            50086,
            87549,
            7413,
            90444,
            12284,
            44970,
            39274,
            81201,
            43353,
            75808,
            14508,
            17389,
            10313,
            90055,
            43102,
            18659,
            20802,
            70315,
            48843,
            12273,
            78876,
            36638,
            17051,
            20478
        ), 5
    )
    assertEquals(1428, example4)
}