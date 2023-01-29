package leetCode.easy

class ConstructTheRectangle {
    fun constructRectangle(area: Int): IntArray {
        var i = 1
        var length = 1
        var width = 1
        while (i <= Math.sqrt(area.toDouble())) {
            if (area.rem(i) == 0) {
                length = area / i
                width = i
            }
            i++
        }

        return intArrayOf(length, width)
    }
}

fun main(args: Array<String>) {
    val solution = ConstructTheRectangle()
    val test1 = solution.constructRectangle(4)
    require(test1.contentEquals(intArrayOf(2, 2)))

    val test2 = solution.constructRectangle(37)
    require(test2.contentEquals(intArrayOf(37, 1)))

    val test3 = solution.constructRectangle(122122)
    require(test3.contentEquals(intArrayOf(427, 286)))
}