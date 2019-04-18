package hackerRank

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    var n: Int = 0
    var k: Int = 0
    var m: Int = 0

    fun deleteWeakness(a: MutableList<Int>) {
        while (n > 1 && m > 0) {
            a.remove(element = a.min())
            n--
            m--
        }
    }

    fun increasePower(a: MutableList<Int>) {
        for (i in 0 until a.size) {
            var currentK = k
            while (currentK > 0 && m > 0) {
                a[i]++
                currentK--
                m--
            }
        }
    }

}

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val firstLine = bufferedReader.readLine().split(" ")
    val solution = Solution()
    solution.n = firstLine[0].toInt()
    solution.k = firstLine[1].toInt()
    solution.m = firstLine[2].toInt()

    val a = bufferedReader.readLine().split(" ").map { it.toInt() }.toMutableList()

    solution.deleteWeakness(a)

    solution.increasePower(a)

    println("%.20f".format(a.average()))
}




