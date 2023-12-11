package leetCode.easy

class ElementAppearingMoreThan25 {
    fun findSpecialInteger(arr: IntArray): Int {
        var counter = 0
        val limit = arr.size * 0.25

        for (i in arr.indices) {
            if (i != 0 && arr[i - 1] != arr[i]) {
                if (counter > limit) return arr[i - 1]
                counter = 0
            }
            counter++
        }

        return arr.last()
    }
}

fun main(args: Array<String>) {
    val solution = ElementAppearingMoreThan25()
    println(solution.findSpecialInteger(intArrayOf(1, 2, 2, 6, 6, 6, 6, 7, 10)))
    println(solution.findSpecialInteger(intArrayOf(1, 1)))
}