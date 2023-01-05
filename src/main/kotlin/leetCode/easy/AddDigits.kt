package leetCode.easy

class AddDigits {
    fun addDigits(num: Int): Int {
        var currentNumber = num

        var newNumber = 0
        while (currentNumber != 0) {
            newNumber += currentNumber.rem(10)
            currentNumber /= 10

            if (currentNumber == 0 && newNumber < 10) {
                break
            } else if (currentNumber == 0) {
                currentNumber = newNumber
                newNumber = 0
            }
        }

        return newNumber
    }
}

fun main(args: Array<String>) {
    println(AddDigits().addDigits(38))
    println(AddDigits().addDigits(0))
}