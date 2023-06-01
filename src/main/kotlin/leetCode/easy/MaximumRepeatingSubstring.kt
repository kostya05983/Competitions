package leetCode.easy

class MaximumRepeatingSubstring {
    fun maxRepeating(sequence: String, word: String): Int {
        var localIndex: Int
        var counter: Int
        var maximum = 0
        for (i in sequence.indices) {
            localIndex = 0
            counter = 0

            for (j in i until sequence.length) {
                val ch = sequence[j]

                if (ch == word[localIndex]) {
                    localIndex++

                    if (localIndex == word.length) {
                        counter++
                        localIndex = 0
                    }
                } else {
                    maximum = maxOf(maximum, counter)

                    localIndex = 0
                    counter = 0
                }
            }
            maximum = maxOf(maximum, counter)
        }

        return maximum
    }
}

fun main(args: Array<String>) {
    val solution = MaximumRepeatingSubstring()

    val example = solution.maxRepeating("ababc", "ab")
    require(example == 2)

    val example2 = solution.maxRepeating("ababc", "ba")
    require(example2 == 1)

    val example3 = solution.maxRepeating("ababc", "ac")
    require(example3 == 0)

    val example4 = solution.maxRepeating("a", "a")
    require(example4 == 1)

    val example5 = solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba")
    require(example5 == 5)
}