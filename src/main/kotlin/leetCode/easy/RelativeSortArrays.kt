package leetCode.easy

class RelativeSortArrays {

    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        var skip = 0
        for (i in 0 until arr2.size) {
            val element = arr2[i]

            for (j in skip until arr1.size) {
                if (element == arr1[j]) {
                    arr1[j] = arr1[skip]
                    arr1[skip] = element
                    skip++
                }
            }
        }

        for (i in skip until arr1.size - 1) {
            var minIndex = i
            var min = arr1[i]
            for (j in i + 1 until arr1.size) {
                if (arr1[j] < min) {
                    minIndex = j
                    min = arr1[j]
                }
            }

            if (minIndex != i) {
                arr1[minIndex] = arr1[i]
                arr1[i] = min
            }
        }

        return arr1
    }
}

fun main(args: Array<String>) {
    val solution = RelativeSortArrays()

    val example1 = solution.relativeSortArray(intArrayOf(26, 21, 11, 20, 50, 34, 1, 18), intArrayOf(21, 11, 26, 20))
    require(example1.contentEquals(intArrayOf())) { "AAAA" }
}