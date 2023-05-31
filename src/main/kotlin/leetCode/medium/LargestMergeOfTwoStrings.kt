package leetCode.medium

class LargestMergeOfTwoStrings {

    /**
     * bbbbbcaaa
     * bbbbbada
     */
    fun largestMerge2(word1: String, word2: String): String {
        val sb = StringBuilder(word1.length + word2.length)

        var temp1 = word1
        var temp2 = word2

        while (temp1.isNotEmpty() || temp2.isNotEmpty()) {
            if (temp1 > temp2) {
                sb.append(temp1[0])
                temp1 = temp1.substring(1)
            } else {
                sb.append(temp2[0])
                temp2 = temp2.substring(1)
            }
        }

        return sb.toString()
    }

    fun largestMerge(word1: String, word2: String): String {
        var index1 = 0
        var index2 = 0

        val sb = StringBuilder(word1.length + word2.length)
        while (index1 <= word1.lastIndex || index2 <= word2.lastIndex) {
            if (compareTo(word1, index1, word2, index2) > 0) {
                sb.append(word1[index1])
                index1++
            } else {
                sb.append(word2[index2])
                index2++
            }
        }

        return sb.toString()
    }

    private fun compareTo(
        word1: String,
        index1: Int,
        word2: String,
        index2: Int
    ): Int {
        var offset = 0

        while (true) {
            val ch3 = word1.getOrNull(index1 + offset)
            val ch4 = word2.getOrNull(index2 + offset)

            if (ch3 == null) {
                return -1
            }

            if (ch4 == null) {
                return +1
            }

            if (ch3 < ch4) {
                return -1
            }

            if (ch3 > ch4) {
                return +1
            }

            if (ch3 == ch4) {
                offset++
            }
        }
    }
}

fun main(args: Array<String>) {
    val solution = LargestMergeOfTwoStrings()

    val example1 = solution.largestMerge("cabaa", "bcaaa")
    require(example1 == "cbcabaaaaa")

    val example2 = solution.largestMerge("abcabc", "abdcaba")
    require(example2 == "abdcabcabcaba")
}