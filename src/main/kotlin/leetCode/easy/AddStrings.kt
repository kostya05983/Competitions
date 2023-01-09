package leetCode.easy

class AddStrings {
    fun addStrings(num1: String, num2: String): String {
        var resultNum = ""
        val biggest = if (num1.length > num2.length) num1 else num2
        val small = if (num1.length > num2.length) num2 else num1

        var j = biggest.length - 1
        var i = small.length - 1
        var remainder = 0
        while (j >= 0) {
            while (i >= 0) {
                remainder += Integer.parseInt("${small[i]}")
                val bigNumber = Integer.parseInt("${biggest[j]}")
                val result = bigNumber + remainder
                resultNum = "${result.rem(10)}" + resultNum
                remainder = result / 10
                i--
                j--
                continue
            }
            if (j >= 0) {
                val bigNumber = Integer.parseInt("${biggest[j]}")
                val result = bigNumber + remainder
                remainder = result / 10

                resultNum = "${result.rem(10)}" + resultNum
                j--
            }
        }
        if (remainder != 0) {
            resultNum = "$remainder" + resultNum
        }

        return resultNum
    }
}

fun main(args: Array<String>) {
    println(AddStrings().addStrings("11", "123"))
    println(AddStrings().addStrings("456", "77"))
    println(AddStrings().addStrings("0", "0"))
    println(AddStrings().addStrings("1", "9"))
    println(AddStrings().addStrings("408", "5"))
    println(AddStrings().addStrings("6994", "36"))
    println(AddStrings().addStrings("9", "99"))
}