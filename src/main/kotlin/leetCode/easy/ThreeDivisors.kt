package leetCode.easy

class ThreeDivisors {
    fun isThree(n: Int): Boolean {
        var count = 0
        for (i in 1..n) {
            if (n.rem(i) == 0) {
                count++
            }
        }

        return count == 3
    }
}