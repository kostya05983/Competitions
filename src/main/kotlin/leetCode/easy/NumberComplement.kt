package leetCode.easy

class NumberComplement {
    fun findComplement(num: Int): Int {
        var result = 0
        var tmp = num
        var pow = 0
        while (tmp != 0) {
            val number = tmp.rem(2).xor(1)
            result += number * pow2(pow)

            tmp /= 2
            pow++
        }

        return result
    }

    private fun pow2(pow: Int): Int {
        if (pow == 0) return 1
        var temp = 1
        for (i in 0 until pow) {
            temp *= 2
        }
        return temp
    }
}

fun main(args: Array<String>) {
    val numberComplement = NumberComplement()
    val test1 = numberComplement.findComplement(5)
    require(test1 == 2) { "Test1 failed, result=${test1}" }

    val test2 = numberComplement.findComplement(1)
    require(test2 == 0) { "Test2 failed" }

    val test3 = numberComplement.findComplement(6)
    require(test3 == 1) { "test3 failed" }

    val test4 = numberComplement.findComplement(7)
    require(test4 == 0)

    val test5 = numberComplement.findComplement(8)
    require(test5 == 7)
}