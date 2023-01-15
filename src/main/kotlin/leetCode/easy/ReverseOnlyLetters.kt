package leetCode.easy

class ReverseOnlyLetters {
    fun reverseOnlyLetters(s: String): String {
        val sequence = s.toCharArray()
        var left = 0
        var right = s.length - 1
        while (left < right) {
            val leftCh = sequence[left]
            val righCh = sequence[right]
            if (leftCh.isLetter() && righCh.isLetter()) {
                sequence[right] = leftCh
                sequence[left] = righCh
            }
            if (leftCh.isLetter() && !righCh.isLetter()) {
                right--
                continue
            }
            if (!leftCh.isLetter() && righCh.isLetter()) {
                left++
                continue
            }
            left++
            right--
        }

        return sequence.joinToString("")
    }
}

fun main(args: Array<String>) {
    println(ReverseOnlyLetters().reverseOnlyLetters("ab-cd"))
    println(ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj"))
    println(ReverseOnlyLetters().reverseOnlyLetters("Test1ng-Leet=code-Q!"))
}