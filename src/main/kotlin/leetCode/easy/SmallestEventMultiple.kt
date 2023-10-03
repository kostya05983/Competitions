package leetCode.easy

class SmallestEventMultiple {
    fun smallestEvenMultiple(n: Int): Int {
        if (n.rem(2) == 0) return n

        return n * 2
    }
}