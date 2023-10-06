package leetCode.medium

class IntegerBreak {
    fun integerBreak(n: Int): Int {
        if (n==2 || n==3) return n-1

        var current = n

        var multiplicator = 1
        while (current > 4) {
            current -= 3
            multiplicator *= 3
        }

        return current * multiplicator
    }
}


fun main(args: Array<String>) {

}