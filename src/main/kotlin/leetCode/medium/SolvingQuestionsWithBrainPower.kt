package leetCode.medium

class SolvingQuestionsWithBrainPower {

    fun mostPointsRecursive(questions: Array<IntArray>): Long {

        return traverse(questions, 0)
    }

    private fun traverse(questions: Array<IntArray>, index: Int): Long {
        if (index > questions.lastIndex) return 0

        val (points, brainPower) = questions[index]

        return maxOf(
            points + traverse(questions, index + brainPower + 1),
            traverse(questions, index + 1)
        )
    }

    fun mostPoints(questions: Array<IntArray>): Long {
        val maxes = LongArray(questions.size)

        var index = questions.lastIndex
        while (index >= 0) {
            val (points, brainPower) = questions[index]

            val temp = points + (maxes.getOrNull(index + 1 + brainPower) ?: 0L)
            maxes[index] = maxOf(points.toLong(), (maxes.getOrNull(index + 1) ?: 0L), temp)

            index--
        }

        return maxes[0]
    }
}

//[[21,2],[1,2],[12,5],[7,2],[35,3],[32,2],[80,2],[91,5],[92,3],[27,3],[19,1],[37,3],[85,2],[33,4],[25,1],[91,4],[44,3],[93,3],[65,4],[82,3],[85,5],[81,3],[29,2],[25,1],[74,2],[58,1],[85,1],[84,2],[27,2],[47,5],[48,4],[3,2],[44,3],[60,5],[19,2],[9,4],[29,5],[15,3],[1,3],[60,2],[63,3],[79,3],[19,1],[7,1],[35,1],[55,4],[1,4],[41,1],[58,5]]

fun main(args: Array<String>) {
    val solution = SolvingQuestionsWithBrainPower()

//    val result1 = solution.mostPoints(arrayOf(intArrayOf(3, 2), intArrayOf(4, 3), intArrayOf(4, 4), intArrayOf(2, 5)))
//    require(result1 == 5L) { "$result1" }
//
//    val result2 = solution.mostPoints(
//        arrayOf(
//            intArrayOf(1, 1),
//            intArrayOf(2, 2),
//            intArrayOf(3, 3),
//            intArrayOf(4, 4),
//            intArrayOf(5, 5)
//        )
//    )
//    require(result2 == 7L) { "$result2" }
//
//    val result3 = solution.mostPoints(
//        arrayOf(
//            intArrayOf(1, 1),
//            intArrayOf(2, 2),
//            intArrayOf(3, 3),
//            intArrayOf(4, 4),
//            intArrayOf(5, 5),
//            intArrayOf(6, 6),
//            intArrayOf(7, 7),
//            intArrayOf(8, 8),
//            intArrayOf(9, 9)
//        )
//    )
//    require(result3 == 14L) { "$result3" }

    val input =
        "[21,2],[1,2],[12,5],[7,2],[35,3],[32,2],[80,2],[91,5],[92,3],[27,3],[19,1],[37,3],[85,2],[33,4],[25,1],[91,4],[44,3],[93,3],[65,4],[82,3],[85,5],[81,3],[29,2],[25,1],[74,2],[58,1],[85,1],[84,2],[27,2],[47,5],[48,4],[3,2],[44,3],[60,5],[19,2],[9,4],[29,5],[15,3],[1,3],[60,2],[63,3],[79,3],[19,1],[7,1],[35,1],[55,4],[1,4],[41,1],[58,5]"

    val lines = input.replace("]", "").replace("[", "").split(",").chunked(2)
        .map {
            intArrayOf(it[0].toInt(), it[1].toInt())
        }.toTypedArray()

    val result4 = solution.mostPoints(lines)
    require(result4 == 781L) { "$result4" }

}

