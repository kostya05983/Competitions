package leetCode.easy

class SqrtX {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        if (x < 4) return 1

        var left = 2
        var right = x / 2

        while (true) {
            val diff = right - left
            if (diff <= 1) return left

            val middle = diff / 2 + left
            val middleLong = middle.toLong()

            val pow = middleLong * middleLong

            if (pow < x) {
                left = middle
            } else if (pow > x) {
                right = middle
            } else {
                return middle
            }
        }
    }
}

fun main(args: Array<String>) {

}