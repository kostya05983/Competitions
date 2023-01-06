package leetCode.easy

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while (left <= right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp

            left++
            right--
        }
    }
}

fun main(args: Array<String>) {
    val s = charArrayOf('h', 'e', 'l', 'l', 'o')
    ReverseString().reverseString(s)
    println(s)
}