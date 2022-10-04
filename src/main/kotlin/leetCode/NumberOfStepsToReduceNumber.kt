package leetCode

class NumberOfStepsToReduceNumber {
    fun numberOfSteps(num: Int): Int {
        var stepAmount = 0
        var current = num
        while (current != 0) {

            if (current.and(1) == 0) {
                current = current.shr(1)
            } else {
                current--
            }
            stepAmount++
        }
        return stepAmount
    }
}

fun main(args: Array<String>) {
    println(NumberOfStepsToReduceNumber().numberOfSteps(14))
}