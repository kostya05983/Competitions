package leetCode.easy

class ReplaceElementWithGreatesRight {
    fun replaceElements(arr: IntArray): IntArray {
        for (i in 0 until arr.size) {
            arr[i] = findGreatestElement(i + 1, arr)
        }
        return arr
    }

    private fun findGreatestElement(index: Int, arr: IntArray): Int {
        if (index == arr.size) return -1

        var max = -1
        for (i in index until arr.size) {
            if (arr[i] > max) {
                max = arr[i]
            }
        }
        return max
    }
}

fun main(args: Array<String>) {
    println(ReplaceElementWithGreatesRight().replaceElements(intArrayOf(400)).toList())
}