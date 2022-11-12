package leetCode

class ReverseInteger {
    fun reverse(x: Int): Int {
        var temp = x
        if (x == 0) return 0
        var result = temp.rem(10)
        temp /= 10

        while (temp != 0) {
            val remain = temp.rem(10)
            temp /= 10

            result = result * 10 + remain
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(ReverseInteger().reverse(120))
}