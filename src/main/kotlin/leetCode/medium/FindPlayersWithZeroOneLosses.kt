package leetCode.medium

class FindPlayersWithZeroOneLosses {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val defeated = HashMap<Int, Int>()

        for (match in matches) {
            val (win, defeat) = match
            defeated[defeat] = defeated.getOrDefault(defeat, 0) + 1
            defeated[win] = defeated.getOrDefault(win, 0)
        }

        val winners = defeated.filter { it.value == 0 }.keys.sorted()
        val losers = defeated.filter { it.value == 1 }.keys.sorted()

        return listOf(winners, losers)
    }
}

fun main(args: Array<String>) {
    val solution = FindPlayersWithZeroOneLosses()
}