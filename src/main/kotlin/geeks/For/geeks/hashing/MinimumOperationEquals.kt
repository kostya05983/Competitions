package geeks.For.geeks.hashing

class MinimumOperationEquals {

    fun solve(array: IntArray): Int {
        val frequencies = HashMap<Int, Int>()
        for (number in array) {
            frequencies[number] = frequencies[number]?.plus(1) ?: 1
        }

        val max = frequencies.maxBy { it.value }!!.value

        return array.size - max
    }
}