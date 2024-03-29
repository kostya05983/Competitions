package leetCode.medium

import org.junit.jupiter.api.Assertions.assertArrayEquals

class SuccessfulPairsOfSpellsAndPotions {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val result = IntArray(spells.size)

        val indexedSpell = spells.mapIndexed { index, i -> Pair(i, index) }
        val sortedSpells = indexedSpell.sortedBy { it.first }
        potions.sortDescending()

        val maxSize = potions.size
        var right = 0
        for (i in sortedSpells.indices) {
            var count = 0
            val spell = sortedSpells[i].first.toLong()
            if (i != 0 && right == maxSize) {
                result[sortedSpells[i].second] = right
                continue
            }

            var j = right
            while (j < potions.size) {
                val potion = potions[j]
                val product = spell * potion
                if (product >= success) {
                    count++
                } else {
                    right = j
                    break
                }
                j++
            }
            if (j == potions.size) right = j

            result[sortedSpells[i].second] = minOf(maxSize, right)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = SuccessfulPairsOfSpellsAndPotions()
    val example1 = solution.successfulPairs(intArrayOf(5, 1, 3), intArrayOf(1, 2, 3, 4, 5), 7)
    assertArrayEquals(intArrayOf(4, 0, 3), example1)

    val example2 = solution.successfulPairs(intArrayOf(3, 1, 2), intArrayOf(8, 5, 8), 16)
    assertArrayEquals(intArrayOf(2, 0, 2), example2)

    val example3 = solution.successfulPairs(intArrayOf(15, 8, 19), intArrayOf(38, 36, 23), 328)
    assertArrayEquals(intArrayOf(3, 0, 3), example3)
}