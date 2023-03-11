package leetCode.easy

class DivisorGame {
    fun divisorGame(n: Int): Boolean {
        return n.rem(2) == 0
    }
}

fun main(args: Array<String>) {
    val solution = DivisorGame()
    val test1 = solution.divisorGame(2)
    require(test1)

    val test2 = solution.divisorGame(3)
    require(!test2)
}