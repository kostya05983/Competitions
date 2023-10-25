package leetCode.easy

class JewelsAndStones {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelsSet = jewels.toSet()

        var count = 0
        for (ch in stones) {
            if (jewelsSet.contains(ch)) count++
        }

        return count
    }
}