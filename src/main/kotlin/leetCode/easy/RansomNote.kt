package leetCode.easy

class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val set = mutableMapOf<Char, Int>()
        for (ch in magazine) {
            set[ch] = set.getOrDefault(ch, 0) + 1
        }
        for (ch in ransomNote) {
            val entry = set[ch]
            if (entry != null && entry >= 1) {
                set[ch] = entry - 1
            } else return false
        }

        return true
    }

}

fun main(args: Array<String>) {
    println(RansomNote().canConstruct("a", "b"))
    println(RansomNote().canConstruct("aa", "ab"))
    println(RansomNote().canConstruct("aa", "aab"))
}