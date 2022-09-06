package leetCode

class SquaresOfSortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        var leftPointer = 0
        var rightPointer = 0
        for (i in nums.indices) {
            if (nums[i] == 0) {
                leftPointer = i
                rightPointer = i
                break
            }
            if (nums[i] < 0) {
                leftPointer = i
                rightPointer = i
            }
            if (nums[i] > 0 && nums[rightPointer] < 0) {
                rightPointer = i
            }
        }

        val result = IntArray(nums.size)
        var currentSize = 0
        while (leftPointer != -1 || rightPointer < nums.size) {
            val left = if (leftPointer != -1) {
                nums[leftPointer] * nums[leftPointer]
            } else null
            val right = if (rightPointer != nums.size) {
                nums[rightPointer] * nums[rightPointer]
            } else null

            if (left != null && right != null && left < right) {
                leftPointer--
                result[currentSize] = left
            } else if (left != null && right != null && right < left) {
                rightPointer++
                result[currentSize] = right
            } else if (right == null && left != null) {
                result[currentSize] = left
                leftPointer--
            } else if (left == null && right != null) {
                result[currentSize] = right
                rightPointer++
            } else if (nums[leftPointer] == nums[rightPointer]) {
                result[currentSize] = left!!
                leftPointer--
                rightPointer++
            } else if (left == right && left != null && right != null) {
                result[currentSize] = left
                currentSize++
                result[currentSize] = right
                leftPointer--
                rightPointer++
            }
            currentSize++
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(SquaresOfSortedArray().sortedSquares(intArrayOf(-5, -3, -2, -1)).toList())
    println(SquaresOfSortedArray().sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).toList())
    println(SquaresOfSortedArray().sortedSquares(intArrayOf(-7, -3, 2, 3, 11)).toList())
    println(SquaresOfSortedArray().sortedSquares(intArrayOf(-1, 2, 2)).toList())
}