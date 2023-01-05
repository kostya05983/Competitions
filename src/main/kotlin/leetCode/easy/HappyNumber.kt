package leetCode.easy

class HappyNumber {
    tailrec fun isHappy(n: Int): Boolean {
        if (n == 1 || n == 7) return true

        val parts = mutableListOf<Int>()
        var number = n
        while (number != 0) {
            parts.add(number.rem(10))
            number /= 10
        }
        if (parts.size == 1) return false

        var newNumber = 0
        for (part in parts) {
            newNumber += part * part
        }

        return isHappy(newNumber)
    }
}

fun main(args: Array<String>) {
    println(HappyNumber().isHappy(19))
    println(HappyNumber().isHappy(2))
    println(HappyNumber().isHappy(7))
}