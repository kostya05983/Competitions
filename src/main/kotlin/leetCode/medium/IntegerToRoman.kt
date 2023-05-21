package leetCode.medium

class IntegerToRoman {

    fun intToRoman(num: Int): String {
        var temp = num
        var result = ""

        while (temp != 0) {
            when {
                temp >= 1000 -> {
                    result += "M"
                    temp -= 1000
                }

                temp >= 900 -> {
                    result += "CM"
                    temp -= 900
                }

                temp >= 500 -> {
                    result += "D"
                    temp -= 500
                }

                temp >= 400 -> {
                    result += "CD"
                    temp -= 400
                }

                temp >= 100 -> {
                    result += "C"
                    temp -= 100
                }

                temp >= 90 -> {
                    result += "XC"
                    temp -= 90
                }

                temp >= 50 -> {
                    result += "L"
                    temp -= 50
                }

                temp >= 40 -> {
                    result += "XL"
                    temp -= 40
                }

                temp >= 10 -> {
                    result += "X"
                    temp -= 10
                }

                temp == 9 -> {
                    result += "IX"
                    temp -= 9
                }

                temp >= 5 -> {
                    result += "V"
                    temp -= 5
                }

                temp == 4 -> {
                    result += "IV"
                    temp -= 4
                }
                else -> {
                    result += "I"
                    temp -= 1
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(IntegerToRoman().intToRoman(1994))
}