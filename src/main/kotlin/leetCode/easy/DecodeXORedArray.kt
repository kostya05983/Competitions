package leetCode.easy

class DecodeXORedArray {
    fun decode(encoded: IntArray, first: Int): IntArray {
        val result = IntArray(encoded.size + 1)
        result[0] = first

        for (i in encoded.indices) {
            result[i + 1] = encoded[i].xor(result[i])
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = DecodeXORedArray()
    val example1 = solution.decode(intArrayOf(1, 2, 3), 1)
    println(example1.toList())

    val example2 = solution.decode(intArrayOf(6, 2, 7, 3), 4)
    println(example2.toList())
}