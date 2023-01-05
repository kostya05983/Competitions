package leetCode.easy

class UglyNumber {
    fun isUgly(n: Int): Boolean {
        if (n == 0) return false
        var current = n

        while (current != 1) {
            if (current.rem(2) == 0) {
                current /= 2
                continue
            }
            if (current.rem(3) == 0) {
                current /= 3
                continue
            }
            if (current.rem(5) == 0) {
                current /= 5
                continue
            }
            return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    println(UglyNumber().isUgly(6))
    println(UglyNumber().isUgly(1))
    println(UglyNumber().isUgly(14))

}