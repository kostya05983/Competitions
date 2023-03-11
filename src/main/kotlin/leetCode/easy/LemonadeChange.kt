package leetCode.easy

class LemonadeChange {
    fun lemonadeChange(bills: IntArray): Boolean {
        var fiveBankNote = 0
        var tenBankNote = 0

        for (bill in bills) {
            when (bill) {
                5 -> {
                    fiveBankNote++
                }

                10 -> {
                    fiveBankNote--
                    tenBankNote++
                }

                20 -> {
                    if (tenBankNote > 0) {
                        tenBankNote--
                        fiveBankNote--
                    } else {
                        fiveBankNote -= 3
                    }
                }
            }

            if (fiveBankNote < 0 || tenBankNote < 0) return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution = LemonadeChange()
    val test1 = solution.lemonadeChange(intArrayOf(5, 5, 5, 10, 20))
    require(test1)

    val test2 = solution.lemonadeChange(intArrayOf(5, 5, 10, 10, 20))
    require(!test2)
}