package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.TreeMap

class BoatsToSavePeople {

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var left = 0
        var right = people.lastIndex

        var boatsCount = 0
        while (left <= right) {
            if (people[left] + people[right] <= limit)
                left++
            boatsCount++
            right--
        }
        val map = TreeMap<Int,Int>()
        map.flo

        return boatsCount
    }
}

fun main(args: Array<String>) {
    val solution = BoatsToSavePeople()
    val example1 = solution.numRescueBoats(intArrayOf(1, 2), 3)
    assertEquals(1, example1)

    //1,2,2,3
    val example2 = solution.numRescueBoats(intArrayOf(3, 2, 2, 1), 3)
    assertEquals(3, example2)

    //3,3,4,5
    val example3 = solution.numRescueBoats(intArrayOf(3, 5, 3, 4), 5)
    assertEquals(4, example3)

    val example4 = solution.numRescueBoats(intArrayOf(3, 2, 3, 2, 2), 6)
    assertEquals(3, example4)
}