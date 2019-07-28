package geeks.For.geeks.hashing

class PairAsSum {

    fun solve(array: IntArray, x: Int): String {
        val sb = StringBuilder()
        val map = HashSet<Int>()
        for (i in 0 until array.size) {
            val temp = x - array[i]

            if (map.contains(temp)) {
                sb.append("Pair ${array[i]} and $temp")
            }
            map.add(array[i])
        }
        return sb.toString()
    }
}