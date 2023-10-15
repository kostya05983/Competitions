package leetCode.medium

import java.util.*

class ShortestLexicographicallySmallestBeautiful {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val heap = PriorityQueue<String> { o1, o2 ->
            if (o1.length == o2.length) {
                o1.compareTo(o2)
            } else {
                o1.length.compareTo(o2.length)
            }
        }

        var currentK = 0

        var left = 0
        var right = 0

        while (right < s.length || left < s.length && currentK == k) {
            if (right < s.length && s[right] == '1') {
                currentK++
            }
            if (right >= s.length) {
                val polled = s[left]
                if (polled == '1') {
                    break
                }
                left++
            }

            while (currentK > k) {
                val polled = s[left]
                if (polled == '1') currentK--
                left++
            }

            while (left < s.length && s[left] == '0') {
                left++
            }

            if (currentK == k) {
                if (right >= s.length) {
                    heap.add(s.substring(left, s.length))
                } else {
                    heap.add(s.substring(left, right + 1))
                }
            }
            right++
        }

        return if (heap.isEmpty()) "" else heap.peek()
    }
}

fun main(args: Array<String>) {
    val solution = ShortestLexicographicallySmallestBeautiful()
    println(solution.shortestBeautifulSubstring("100011001", 3))
    println(solution.shortestBeautifulSubstring("1011", 2))
    println(solution.shortestBeautifulSubstring("000", 1))
    println(solution.shortestBeautifulSubstring("0000000000011", 2))
    println(solution.shortestBeautifulSubstring("1100000000", 2))
    println(solution.shortestBeautifulSubstring("000001000010000", 2))
    println(solution.shortestBeautifulSubstring("10000001", 2))
    println(solution.shortestBeautifulSubstring("101", 1))

    println(solution.shortestBeautifulSubstring("1100001110111100100", 8))
}