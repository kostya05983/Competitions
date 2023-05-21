package leetCode.easy

class RomanToInteger {
    fun romanToInt(s: String): Int {
        var result = 0

        var i = 0
        while (i < s.length) {
            val ch = s[i]
            val next = takeIf { i != s.length - 1 }?.let { s[i + 1] }

            when {
                ch == 'I' && next == 'V' -> {
                    result += 4
                    i++
                }

                ch == 'I' && next == 'X' -> {
                    result += 9
                    i++
                }

                ch == 'X' && next == 'L' -> {
                    result += 40
                    i++
                }

                ch == 'X' && next == 'C' -> {
                    result += 90
                    i++
                }

                ch == 'C' && next == 'D' -> {
                    result += 400
                    i++
                }

                ch == 'C' && next == 'M' -> {
                    result += 900
                    i++
                }

                ch == 'I' -> {
                    result += 1
                }

                ch == 'V' -> {
                    result += 5
                }

                ch == 'X' -> {
                    result += 10
                }

                ch == 'L' -> {
                    result += 50
                }

                ch == 'C' -> {
                    result += 100
                }

                ch == 'D' -> {
                    result += 500
                }

                ch == 'M' -> {
                    result += 1000
                }
            }
            i++
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(RomanToInteger().romanToInt("III"))
    println(RomanToInteger().romanToInt("LVIII"))
    println(RomanToInteger().romanToInt("MCMXCIV"))

}