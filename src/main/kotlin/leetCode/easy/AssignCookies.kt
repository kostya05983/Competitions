package leetCode.easy

import java.util.*

class AssignCookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        Arrays.sort(g)
        Arrays.sort(s)

        var childIndex = 0
        var cookieIndex = 0
        var result = 0
        while (childIndex < g.size && cookieIndex < s.size) {
            if (s[cookieIndex] < g[childIndex]) {
                cookieIndex++
            } else {
                childIndex++
                cookieIndex++
                result++
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(AssignCookies().findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(AssignCookies().findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}