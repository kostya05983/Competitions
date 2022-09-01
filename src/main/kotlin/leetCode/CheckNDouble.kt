package leetCode

class CheckNDouble {
    fun checkIfExist(arr: IntArray): Boolean {
        var zeros = 0
        for (i in arr.indices) {
            for (j in arr.indices) {
                if (2 * arr[i] == arr[j] && arr[i] != 0) return true
            }
            if (arr[i] == 0) {
                zeros++
            }
        }
        if (zeros >= 2) {
            return true
        }
        return false
    }
}

fun main(args: Array<String>) {
    println(CheckNDouble().checkIfExist(intArrayOf(0, 0)))
}