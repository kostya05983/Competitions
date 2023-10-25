package leetCode.medium

class PowerfulIntegers {
    fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        var i = 0.0
        var count = 0.0

        val result = HashSet<Int>()
        var currentX = Math.pow(x.toDouble(), i)
        while (currentX + 1 <= bound) {
            currentX = Math.pow(x.toDouble(), i)

            var current = currentX
            var j = 0.0
            while (current < bound) {
                current = currentX + Math.pow(y.toDouble(), j)
                if (current <= bound) result.add(current.toInt())

                if (y == 1) break
                j++
            }

            if (x == 1) break
            count = maxOf(j, count)
            i++
        }

        return result.toList()
    }
}

fun main(args: Array<String>) {
    val solution = PowerfulIntegers()
    println(solution.powerfulIntegers(2, 3, 10))
    println(solution.powerfulIntegers(3, 5, 15))
    println(solution.powerfulIntegers(2, 1, 10))
    println(solution.powerfulIntegers(1, 2, 10))
}