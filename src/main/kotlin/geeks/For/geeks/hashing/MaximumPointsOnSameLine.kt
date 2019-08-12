package geeks.For.geeks.hashing

import kotlin.math.max

/**
 * @author kostya05983
 */
class MaximumPointsOnSameLine {

    fun solve(array: Array<Pair<Int, Int>>): Int {
        val hashMap = HashMap<Pair<Int, Int>, Int>()
        var maxPoint = 0
        var currMax = 0
        for (i in 0 until array.size) {
            var overlapPoint = 0
            var verticalPoints = 0
            for (j in i + 1 until array.size) {
                when {
                    array[i] == array[j] -> overlapPoint++
                    array[i].first == array[j].first -> verticalPoints++
                    else -> {
                        var yDif = array[i].second - array[j].second
                        var xDif = array[i].first - array[j].first

                        val g = gcd(xDif, yDif)

                        yDif /= g
                        xDif /= g

                        val pair = Pair(yDif, xDif)
                        hashMap[pair] = hashMap[pair]?.plus(1) ?: 1
                        currMax = max(currMax, hashMap[pair]!!)
                    }
                }
                currMax = max(currMax, verticalPoints)
            }
            maxPoint = max(maxPoint, currMax + overlapPoint + 1)
            hashMap.clear()
        }
        return maxPoint
    }

    fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val tmp = a % b
            a = b
            b = tmp
        }
        return a
    }
}