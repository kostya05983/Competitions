package leetCode.medium

class ReverseInteger {
    fun reverse(x: Int): Int {
        var temp = x
        if (x == 0) return 0
        var result = temp.rem(10)
        temp /= 10

        while (temp != 0) {
            val remain = temp.rem(10)
            temp /= 10

            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && remain > 7) return 0
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && remain < -8) return 0
            result = result * 10 + remain
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(ReverseInteger().reverse(1534236469))
}