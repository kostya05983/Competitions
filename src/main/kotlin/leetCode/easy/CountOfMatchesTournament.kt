package leetCode.easy

class CountOfMatchesTournament {
    fun numberOfMatches(n: Int): Int {
        var matchesCount = 0

        var teams = n
        while (teams != 1) {
            if (teams.rem(2) == 0) {
                matchesCount += teams / 2
                teams = teams / 2
            } else {
                matchesCount += (teams - 1) / 2
                teams = (teams - 1) / 2 + 1
            }
        }

        return matchesCount
    }
}

fun main(args: Array<String>) {
    val solution = CountOfMatchesTournament()
    println(solution.numberOfMatches(7))
    println(solution.numberOfMatches(14))
}