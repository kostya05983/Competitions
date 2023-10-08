package leetCode.easy

class DivisibleAndNonDivisibleSumDifference {
    fun differenceOfSums(n: Int, m: Int): Int {
        var notDivisible = 0
        var divisible = 0

        for (i in 1..n) {
            if (i.rem(m) == 0) {
                divisible += i
            } else {
                notDivisible += i
            }
        }

        return notDivisible - divisible
    }
}