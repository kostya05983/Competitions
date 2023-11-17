package leetCode.medium

import java.lang.Math.abs

class ValidSquare {
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        val pArray = arrayOf(p1, p2, p3, p4)
        pArray.sortWith({ o1, o2 -> if (o2[0] == o1[0]) o1[1] - o2[1] else o1[0] - o2[0] })

        val secondSide = vectorSquare(pArray[0], pArray[1])
        val thirdSide = vectorSquare(pArray[0], pArray[2])
        val fourthSide = vectorSquare(pArray[0], pArray[3])

        if (secondSide == 0 || thirdSide == 0 || fourthSide == 0) return false

        if (secondSide == thirdSide && 2 * secondSide == fourthSide && 2 * vectorSquare(
                pArray[1],
                pArray[3]
            ) == vectorSquare(pArray[1], pArray[2])
        )
            return true

        if (thirdSide == fourthSide && 2 * thirdSide == secondSide && 2 * vectorSquare(
                pArray[2],
                pArray[1]
            ) == vectorSquare(pArray[2], pArray[3])
        )
            return true

        if (secondSide == fourthSide && 2 * secondSide == thirdSide && 2 * vectorSquare(
                pArray[1],
                pArray[2]
            ) == vectorSquare(pArray[1], pArray[3])
        )
            return true


        return false
    }

    private fun vectorSquare(p1: IntArray, p2: IntArray): Int {
        val distanceX = p1[0] - p2[0]
        val distanceY = p1[1] - p2[1]
        return distanceX * distanceX + distanceY * distanceY
    }
}

fun main(args: Array<String>) {
    val solution = ValidSquare()
    println(solution.validSquare(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(0, 1)))
}