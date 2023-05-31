package leetCode.medium

class LargestMergeOfTwoStrings {

    /**
     * bbbbbcaaa
     * bbbbbada
     */
    fun largestMerge(word1: String, word2: String): String {
        var index1 = 0
        var index2 = 0

        val sb = StringBuilder(word1.length + word2.length)
        while (index1 <= word1.lastIndex || index2 <= word2.lastIndex) {
            val ch1 = word1.getOrNull(index1)
            val ch2 = word2.getOrNull(index2)

            when {
                ch1 == null -> {
                    sb.append(ch2)
                    index2++
                }

                ch2 == null -> {
                    sb.append(ch1)
                    index1++
                }

                ch1 < ch2 -> {
                    sb.append(ch2)
                    index2++
                }

                ch1 > ch2 -> {
                    sb.append(ch1)
                    index1++
                }

                ch1 == ch2 -> {
                    var localIndex1 = index1 + 1
                    var localIndex2 = index2 + 1
                    while (true) {
                        val ch3 = word1.getOrNull(localIndex1)
                        val ch4 = word2.getOrNull(localIndex2)

                        if (ch3 == null) {
                            sb.append(ch2)
                            index2++
                            break
                        }

                        if (ch4 == null) {
                            sb.append(ch1)
                            index1++
                            break
                        }

                        if (ch3 < ch4) {
                            sb.append(ch2)
                            index2++
                            break
                        }

                        if (ch3 > ch4) {
                            sb.append(ch1)
                            index1++
                            break
                        }

                        if (ch3 == ch4) {
                            localIndex1++
                            localIndex2++
                        }
                    }
                }

                else -> throw IllegalStateException("Wrong state")
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = LargestMergeOfTwoStrings()

    val example1 = solution.largestMerge("cabaa", "bcaaa")
    require(example1 == "cbcabaaaaa")

    val example2 = solution.largestMerge("abcabc", "abdcaba")
    require(example2 == "abdcabcabcaba")
}