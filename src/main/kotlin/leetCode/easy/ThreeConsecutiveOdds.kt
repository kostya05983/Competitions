package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class ThreeConsecutiveOdds {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var i = 0

        var counter = 0
        while (i < arr.size) {
            if (counter >= 3) return true
            if (arr[i].rem(2) == 0) {
                counter = 0
            } else {
                counter++
            }
            i++
        }

        return counter >= 3
    }
}

fun main(args: Array<String>) {
    val solution = ThreeConsecutiveOdds()
    val example1 = solution.threeConsecutiveOdds(intArrayOf(2, 6, 4, 1))
    assertEquals(false, example1)

    val example2 = solution.threeConsecutiveOdds(intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12))
    assertEquals(true, example2)
}