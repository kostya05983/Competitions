package geeks.For.geeks.hashing

/**
 * @author kostya05983
 * Find minumum of deletions to make all elements equals
 */
class MinimumDelete {

    fun solve(array: IntArray): Int {
        val map = HashMap<Int, Int>();

        for (number in array) {
            if (map.contains(number)) {
                map[number] = map[number]?.plus(1) ?: 1
            } else {
                map[number] = 1
            }
        }

        val maxBy = map.maxBy { it.value }
        return map.map { if (it!=maxBy) it.value else 0 }.sum()
    }
}