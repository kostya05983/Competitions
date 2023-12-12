package leetCode.easy

class FindMaximumStringPairs {
    fun maximumNumberOfStringPairs(words: Array<String>): Int {
        var count = 0

        val map = HashMap<String, Int?>()
        for (word in words) {
            val reversed = word.reversed()

            if (map[reversed] == null) {
                map[word] = 1
            } else {
                map[reversed] = null
                count++
            }
        }

        return count
    }
}