package leetCode.easy

import kotlin.math.abs

class SingleRowKeyboard {
    fun calculateTime(keyboard: String, word: String): Int {
        val chToIndex = HashMap<Char, Int>()

        for (i in keyboard.indices) {
            val ch = keyboard[i]
            chToIndex[ch] = i
        }

        var current = 0
        var result = 0
        for (ch in word) {
            val index = chToIndex[ch]!!
            result += abs(index - current)
            current = index
        }

        return result
    }
}