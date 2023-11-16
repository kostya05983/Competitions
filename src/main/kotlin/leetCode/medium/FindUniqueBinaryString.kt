package leetCode.medium

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet


class FindUniqueBinaryString {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val numsHash = HashSet<String>()
        nums.forEach { numsHash.add(it) }

        return search(nums[0].length, numsHash)
    }

    private fun addZeros(n: Int, s: String): String {
        val sb = StringBuilder()
        for (i in 0 until n - s.length) {
            sb.append('0')
        }

        sb.append(s)
        return sb.toString()
    }

    private fun search(n: Int, numsHash: HashSet<String>): String {
        var up = 2.shl(n) - 1
        val down = 2.shl(n - 1)

        val zeros = addZeros(n, "")
        if (!numsHash.contains(zeros)) return zeros

        val queue = LinkedList<String>()
        queue.add("1")

        while (up-- > down) {
            val s1 = queue.peek()
            queue.remove()

            val check = addZeros(n, s1)
            if (!numsHash.contains(check)) return check

            queue.add(s1 + "0")

            queue.add(s1 + "1")
        }

        return "-1"
    }
}

fun main(args: Array<String>) {
    val solution = FindUniqueBinaryString()
    println(solution.findDifferentBinaryString(arrayOf("01", "10")))
    println(solution.findDifferentBinaryString(arrayOf("00", "01")))
    println(solution.findDifferentBinaryString(arrayOf("111", "011", "001")))
}