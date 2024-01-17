package leetCode.medium

interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    fun f(x: Int, y: Int): Int
};

class FindPositiveIntegerSolutionForGivenEquation {
    fun findSolution(customfunction: CustomFunction, z: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        for (x in 1..1000) {

            var left = 1
            var right = 1000

            while (left <= right) {
                val mid = (left + right) / 2

                val calculated = customfunction.f(x, mid)

                when {
                    calculated == z -> {
                        result.add(listOf(x, mid))
                        break
                    }

                    calculated < z -> {
                        left = mid + 1
                    }

                    calculated > z -> {
                        right = mid - 1
                    }
                }
            }
        }

        return result
    }
}