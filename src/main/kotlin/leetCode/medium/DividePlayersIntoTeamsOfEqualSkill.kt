package leetCode.medium

class DividePlayersIntoTeamsOfEqualSkill {
    fun dividePlayers(skill: IntArray): Long {
        val n = skill.size
        val teamsCount = n / 2
        val sum = skill.sum()

        if (sum.rem(teamsCount) != 0) return -1L

        val sumOfOneTeam = sum / teamsCount

        val skillMap = mutableMapOf<Int, Int>()
        for (item in skill) {
            skillMap[item] = skillMap.getOrDefault(item, 0) + 1
        }

        var chemistryResult = 0L

        for (item in skill) {
            val res = skillMap[item]
            requireNotNull(res)

            if (res == 0) continue

            skillMap[item] = res - 1

            val other = sumOfOneTeam - item

            val otherNumber = skillMap[other] ?: return -1
            if (otherNumber == 0) return -1

            skillMap[other] = otherNumber - 1

            chemistryResult += item * other
        }

        return chemistryResult
    }
}

fun main(args: Array<String>) {
    val solution = DividePlayersIntoTeamsOfEqualSkill()
    println(solution.dividePlayers(intArrayOf(3, 2, 5, 1, 3, 4)))
    println(solution.dividePlayers(intArrayOf(3, 4)))
    println(solution.dividePlayers(intArrayOf(1, 1, 2, 3)))

    println(solution.dividePlayers(intArrayOf(1, 1, 1, 2, 3, 3, 3, 7, 7, 8, 8, 8, 9, 9)))
}