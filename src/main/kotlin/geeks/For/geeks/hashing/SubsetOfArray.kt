package geeks.For.geeks.hashing

class SubsetOfArray {

    fun subArray(sub: IntArray, array: IntArray): Boolean {
        val hash = HashSet<Int>()
        hash.addAll(array.toList())

        for (i in 0 until sub.size) {
            if (!hash.contains(sub[i])) {
                return false
            }
        }
        return true
    }
}