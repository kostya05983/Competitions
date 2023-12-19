package leetCode.easy

class ImageSmoother {
    private var neigboursCount = 0

    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val result = Array(img.size) { IntArray(img[0].size) }

        for (i in img.indices) {
            val row = img[i]

            for (j in row.indices) {
                neigboursCount = 0

                val up = img.getOrDefault(i - 1, j, 0) + img.getOrDefault(
                    i - 1,
                    j - 1,
                    0
                ) + img.getOrDefault(
                    i - 1,
                    j + 1,
                    0
                )
                val mid = img.getOrDefault(i, j - 1, 0) + img.getOrDefault(i, j, 0) + img.getOrDefault(i, j + 1, 0)
                val down = img.getOrDefault(i + 1, j - 1, 0) + img.getOrDefault(i + 1, j, 0) + img.getOrDefault(
                    i + 1,
                    j + 1,
                    0
                )

                val sum = up + mid + down

                result[i][j] = sum / neigboursCount
            }
        }

        return result
    }

    private fun Array<IntArray>.getOrDefault(i: Int, j: Int, default: Int): Int {

        val value = getOrNull(i)?.getOrNull(j)
        if (value != null) {
            neigboursCount++
            return value
        }
        return default
    }
}