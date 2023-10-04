package leetCode.medium

class EliminationGame {
    fun lastRemaining(n: Int): Int {
        if (n == 1) return 1
        return 2 * (n / 2 - lastRemaining(n / 2) + 1)
    }
}

fun main(args: Array<String>) {

}