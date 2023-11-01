package leetCode.easy

class FibonacciNumber {
    fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1

        var first = 0
        var second = 1

        var currentN = 1
        var current = -1
        while (currentN < n) {
            current = first + second
            first = second
            second = current

            currentN++
        }

        return current
    }
}

fun main(args: Array<String>) {
    val solution = FibonacciNumber()
    println(solution.fib(2))
    println(solution.fib(3))
    println(solution.fib(4))
}