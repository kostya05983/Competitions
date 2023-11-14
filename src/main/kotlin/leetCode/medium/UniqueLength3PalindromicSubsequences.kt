package leetCode.medium

class UniqueLength3PalindromicSubsequences {
    /**
     * Why it's not working...
     */
//    fun countPalindromicSubsequence(s: String): Int {
//        val duplicates = IntArray(s.length)
//        var duplicatesCount = 0
//
//        val metChars = HashSet<Char>()
//
//        val leftRightPosition = HashMap<Char, Pair<Int, Int>>()
//
//        for (i in s.indices) {
//            val ch = s[i]
//            if (metChars.contains(ch)) {
//                duplicatesCount++
//            }
//            duplicates[i] = duplicatesCount
//
//            val isFirst = metChars.add(ch)
//            if (isFirst) {
//                leftRightPosition[ch] = Pair(i, -1)
//            } else {
//                leftRightPosition[ch] = Pair(leftRightPosition[ch]!!.first, i)
//            }
//        }
//
//        var result = 0
//        for (entry in leftRightPosition) {
//            val (left, right) = entry.value
//            if (right == -1) continue
//            result += (right - left - 1) - (duplicates[right - 1] - duplicates[left + 1])
//        }
//
//        return result
//    }

    fun countPalindromicSubsequence(s: String): Int {
        val metChars = HashSet<Char>()

        val leftRightPosition = HashMap<Char, Pair<Int, Int>>()

        for (i in s.indices) {
            val ch = s[i]

            val isFirst = metChars.add(ch)
            if (isFirst) {
                leftRightPosition[ch] = Pair(i, -1)
            } else {
                leftRightPosition[ch] = Pair(leftRightPosition[ch]!!.first, i)
            }
        }

        var result = 0
        for (entry in leftRightPosition) {
            val (left, right) = entry.value
            if (right == -1) continue

            val between = HashSet<Char>()
            for (i in left + 1 until right) {
                between.add(s[i])
            }
            result += between.size
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = UniqueLength3PalindromicSubsequences()
    println(solution.countPalindromicSubsequence("aabca"))
    println(solution.countPalindromicSubsequence("adc"))
    println(solution.countPalindromicSubsequence("bbcbaba"))
    println(solution.countPalindromicSubsequence("vdjlhrpfaehcvikmrcoexjlgmfgbtrciozpovvknwmwmcxsnxurqdtezzvdlzlzqvgxxbkkihlwuqnkkdptyyochnikjmpahdpsbxigtxxavhhmscwdzlvhkqefvttwvneindwwafvvglxshvnqdajpewpjextrhkeozwqrgkautaxqpaguhzqljjgmrvkcnrvjqphcbzqwgsxhdtxuuprrsrzgkkasoesfnuxrnvvwecdgvtericjthuighwmwpybxnwjhbwdfkoxlisumqeqahtetmtcpqkzjafjaiverqgsidjpevhhspixzixjeyxkfsdtpejqawgnbzrqarkjomdsqhrrhpdvcsdccffgnfshbmfyiarxvrdcnscggzhmcebhuitctbwrejlqwcvekzhkwuqucsbyekpurejjarvzdxckbgisrtoozrinscrgirkvozbqewwwbmgzbfqkglulwldmqckoacpqhnfryjbfloqmrsctfivzhnsbedsscpeyklusckyvpulrydmnbyvmnxepsdkpwnkzxthzzldksthswsyqfqhirzqynsidjmorktvhwvnadrftehgvrhtavcwtwtoguuhrykyzioagquwvxsqtopuzhereenjlodpgisedibyqrmojuifeb"))
}