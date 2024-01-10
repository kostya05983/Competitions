package leetCode.medium

class LeftmostColumnWithLeastOne {

    interface BinaryMatrix {
        fun get(row: Int, col: Int): Int

        fun dimensions(): IntArray
    }

    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val (rows, cols) = binaryMatrix.dimensions()

        TODO()
    }
}