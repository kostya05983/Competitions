package leetCode.easy

import java.lang.StringBuilder

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs[0]

        val result = StringBuilder()
        var i = 0
        while (true) {
            val ch = takeIf { i <= strs[0].length - 1 }?.let { strs[0][i] } ?: return result.toString()
            for (j in 1 until strs.size) {
                val currentCh = takeIf { i <= strs[j].length - 1 }?.let { strs[j][i] } ?: return result.toString()
                if (currentCh != ch) {
                    return result.toString()
                }
            }
            result.append(ch)
            i++
        }
    }
}

fun main(args: Array<String>) {
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}