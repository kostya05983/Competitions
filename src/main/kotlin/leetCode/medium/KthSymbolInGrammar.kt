package leetCode.medium

class KthSymbolInGrammar {
    fun kthGrammar(n: Int, k: Int): Int {
        if (n == 1) return 0

        return if (k.rem(2) == 0) {
            if (kthGrammar(n - 1, k / 2) == 0) 1
            else 0
        } else {
            if (kthGrammar(n - 1, (k + 1) / 2) == 0) 0
            else 1
        }
    }

    private fun handle(n: Int, k: Int): Int {
        if (n == 1) return 0

        return handle(n - 1, (k + 1) / 2)
    }
}

fun main(args: Array<String>) {
    val solution = KthSymbolInGrammar()
    println(solution.kthGrammar(1, 1))
    println(solution.kthGrammar(2, 1))
    println(solution.kthGrammar(2, 2))
    println(solution.kthGrammar(6, 31))
}