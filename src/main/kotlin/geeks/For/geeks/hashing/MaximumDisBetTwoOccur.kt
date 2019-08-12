package geeks.For.geeks.hashing

/**
 * @author kostya05983
 */
class MaximumDisBetTwoOccur {

    fun solve(array: IntArray): Int {
        val hashMap = hashMapOf<Int, Int>()
        var maxDistance = 0
        for (i in 0 until array.size) {
            if (hashMap.containsKey(array[i])) {
                val distance = i - hashMap[array[i]]!!
                if (distance > maxDistance) {
                    maxDistance = distance
                }
            } else {
                hashMap[array[i]] = i
            }
        }
        return maxDistance
    }
}