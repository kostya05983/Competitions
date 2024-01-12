package leetCode.easy

class DetermineIfStringHalvesAreAlike {
    private val VOWELS = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    fun halvesAreAlike(s: String): Boolean {
        var a = 0
        var b = 0

        val mid = s.length / 2
        for (i in s.indices) {
            val ch = s[i]
            if (!VOWELS.contains(ch)) continue

            if (i < mid) {
                a++
            } else {
                b++
            }
        }

        return a == b
    }
}

fun main(args: Array<String>) {
    val solution = DetermineIfStringHalvesAreAlike()
    println(solution.halvesAreAlike("book"))
    println(solution.halvesAreAlike("textbook"))
}