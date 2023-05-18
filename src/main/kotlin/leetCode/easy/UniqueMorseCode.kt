package leetCode.easy

class UniqueMorseCode {
    private val alphabet = listOf(
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--.."
    )

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val hashSet = hashSetOf<String>()

        for(word in words) {
            val sb = StringBuilder()
            for(ch in word) {
                val index = ch-'a'
                sb.append(alphabet[index])
            }
            hashSet.add(sb.toString())
            sb.clear()
        }

        return hashSet.size
    }
}