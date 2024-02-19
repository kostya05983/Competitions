package leetCode.easy

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
    runBlocking {
        coroutineScope {
            for (i in 0 until 10) {
                GlobalScope.launch {
                    println(i)
                }
            }
        }
    }
//    println(AddDigits().addDigits(38))
//    println(AddDigits().addDigits(0))
}