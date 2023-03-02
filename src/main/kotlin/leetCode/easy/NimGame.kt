package leetCode.easy

class NimGame {
    fun canWinNim(n: Int): Boolean {
        return n.rem(4) != 0
    }
}

fun main(args: Array<String>) {
    val solution = NimGame()

    val test1 = solution.canWinNim(4)
    require(!test1)

    val test2 = solution.canWinNim(1)
    require(test2)

    val test3 = solution.canWinNim(2)
    require(test3)
}