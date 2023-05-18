package leetCode.medium

class IncrementSubmatricesByOne {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }

        for (query in queries) {
            for (i in query[0]..query[2]) {
                for (j in query[1]..query[3]) {
                    matrix[i][j]++
                }
            }
        }

        return matrix
    }
}