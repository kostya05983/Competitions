package leetCode.easy

class FlippingAnImage {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        for (element in image) {
            val row = element
            var k = 0
            var l = row.size - 1
            while (k <= l) {
                if (row[k] == row[l]) {
                    val temp = row[k]
                    row[k] = (row[l] + 1).rem(2)
                    row[l] = (temp + 1).rem(2)
                }
                k++
                l--
            }
        }

        return image
    }
}

fun main(args: Array<String>) {
    println(
        FlippingAnImage().flipAndInvertImage(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 0, 1), intArrayOf(0, 0, 0)))
            .map { it.toList() })

    println(
        FlippingAnImage().flipAndInvertImage(
            arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 0, 0, 1),
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0)
            )
        )
            .map { it.toList() })
}