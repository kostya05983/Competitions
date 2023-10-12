package leetCode.hard

abstract class MountainArray {
    abstract fun get(index: Int): Int
    abstract fun length(): Int
}

class FindInMountainArray {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val peak = binarySearch(mountainArr)
        val value = mountainArr.get(peak)

        if (target > value) return -1
        if (target == value) return peak

        val leftResult = leftBinarySearch(mountainArr, target, peak)
        if (leftResult != -1) return leftResult

        val rightResult = rightBinarySearch(mountainArr, target, peak + 1)
        if (rightResult != -1) return rightResult

        return -1
    }

    private fun rightBinarySearch(mountainArr: MountainArray, target: Int, length: Int): Int {
        var left = length
        var right = mountainArr.length() - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val num = mountainArr.get(mid)

            when {
                num == target -> {
                    return mid
                }

                num < target -> {
                    right = mid - 1
                }

                else -> {
                    left = mid + 1
                }
            }
        }
        return -1
    }

    private fun leftBinarySearch(mountainArr: MountainArray, target: Int, length: Int): Int {
        var left = 0
        var right = length

        while (left <= right) {
            val mid = left + (right - left) / 2
            val num = mountainArr.get(mid)

            when {
                num == target -> {
                    return mid
                }

                num < target -> {
                    left = mid + 1
                }

                else -> {
                    right = mid - 1
                }
            }
        }

        return -1
    }


    private fun binarySearch(mountainArr: MountainArray): Int {
        var left = 0
        var right = mountainArr.length() - 1

        while (left != right) {
            val m = (left + right) / 2
            val value = mountainArr.get(m)
            val next = mountainArr.get(m + 1)
            when {
                next > value -> {
                    left = m + 1
                }

                next < value -> {
                    right = m
                }
            }
        }
        return left
    }
}

fun main(args: Array<String>) {
    val solution = FindInMountainArray()

    val realization = object : MountainArray() {


        override fun get(index: Int): Int {
            return intArrayOf(1, 5, 2)[index]
        }

        override fun length(): Int {
            return intArrayOf(1, 5, 2).size
        }
    }
    val example1 = solution.findInMountainArray(0, realization)
    println(example1)
}