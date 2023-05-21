package leetCode.easy

class ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        var peek = false
        var up = false
        var down = false
        for (i in 0 until arr.size - 1) {
            if (arr[i] < arr[i + 1] && !peek) {
                up = true
            } else if (arr[i] > arr[i + 1] && up) {
                peek = true
                down = true
            } else {
                return false
            }
        }
        return up && down
    }
}

fun main(args: Array<String>) {
    println(ValidMountainArray().validMountainArray(intArrayOf(0,3,2,1)))
}