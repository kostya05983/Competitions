package leetCode.easy

class ArrangingCoins {
    fun arrangeCoins(n: Int): Int {
        var temp = n
        var i = 1
        while (temp > 0) {
            temp -= i
            i++
        }
        return if (temp == 0) {
            i - 1
        } else i - 2
    }
}

fun main(args: Array<String>) {
    println(ArrangingCoins().arrangeCoins(5))
    println(ArrangingCoins().arrangeCoins(6))
    println(ArrangingCoins().arrangeCoins(8))
}