package leetCode.medium

class MostBeautifulItemForEachQuery {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        var maximumBeauty = 0
        var pricePointer = 0
        var queryPointer = 0

        val sortedItems = items.sortedWith(comparator = { o1, o2 ->
            o1[0].compareTo(o2[0])
        })

        val originalIndex = HashMap<Int, Int>()
        for (i in queries.indices) {
            originalIndex[queries[i]] = i
        }

        val sortedQueries = queries.mapIndexed { index, i -> Pair(i, index) }
            .sortedWith(comparator = { o1, o2 -> o1.second.compareTo(o2.second) })

        val result = IntArray(queries.size)

        while (queryPointer < result.size) {
            val money = sortedQueries[queryPointer]

            while (pricePointer < sortedItems.size && money.second >= sortedItems[pricePointer][0]) {
                maximumBeauty = maxOf(sortedItems[pricePointer][1], maximumBeauty)
                pricePointer++
            }

            result[money.first] = maximumBeauty
            queryPointer++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MostBeautifulItemForEachQuery()
    val example1 = solution.maximumBeauty(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 6),
            intArrayOf(3, 5)
        ),
        intArrayOf(1, 2, 3, 4, 5, 6)
    )
    println(example1.toList())
}