package leetCode.easy

class FizzBuzzSolution {
    fun fizzBuzz(n: Int): List<String> {
        var i = 1
        val result = ArrayList<String>(n)
        while (i <= n) {
            when {
                i.rem(3) == 0 && i.rem(5) == 0 -> {
                    result.add("FizzBuzz")
                }
                i.rem(3) == 0 -> {
                    result.add("Fizz")
                }
                i.rem(5) == 0 -> {
                    result.add("Buzz")
                }
                else -> result.add(i.toString())
            }
            i++
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(FizzBuzzSolution().fizzBuzz(15))
}