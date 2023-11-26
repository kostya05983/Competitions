package leetCode.easy

class BestPokerHand {
    fun bestHand(ranks: IntArray, suits: CharArray): String {
        val frequencies = mutableMapOf<Int, Int>()
        for (rank in ranks) {
            frequencies[rank] = frequencies.getOrDefault(rank, 0) + 1
        }
        val maxRank = frequencies.values.max()

        val suitFrequencies = HashMap<Char, Int>()
        for (suit in suits) {
            suitFrequencies[suit] = suitFrequencies.getOrDefault(suit, 0) + 1
        }
        val maxSuit = suitFrequencies.values.max()

        return when {
            maxSuit >= 5 -> "Flush"
            maxRank >= 3 -> "Three of a Kind"
            maxRank == 2 -> "Pair"
            else -> "High Card"
        }
    }
}