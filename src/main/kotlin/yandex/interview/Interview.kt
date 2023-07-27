package yandex.interview

//https://interview.yandex-team.ru/room/rcqt5xc3kb

//Нужно написать банкомат.
//Банкомат инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом. //Человек не выбирает купюры какими выдать, это ответственность лежит на стороне банкомата
//При выдаче купюры списываются с баланса банкомата. //thread-safe не нужен, т.к банкоматом пользуются в очереди, рассмотрим простой банкомат с 1 окном
//Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.//аналитика, если бы поддерживали валюты других стран

enum class MoneyType {
    RUBLE
}

typealias MoneyNominal = Int

data class Money(
    val type: MoneyType,
    val value: Map<MoneyNominal, Int>
) {
    init {
        require(value.isNotEmpty()) { "Должен быть хоть 1 вид купюры" }
    }
}

sealed class GetCashMachineResult {
    data class Success(val value: Map<MoneyNominal, Int>) : GetCashMachineResult()

    object InsufficientFunds : GetCashMachineResult()
}


//Не проверяем сколько денег на счёте у конкретного человека
class CashMachine(
    moneys: List<Money>
) {
    init {
//        require(moneys.groupBy { it.type }.size != moneys.size) { "В массиве валют, каждая валюта должна быть одного типа" } //переформулировать
    }

    private val worldMoney = moneys.associate { it.type to it.value }.toMutableMap()

    fun get(amount: Int, type: MoneyType): GetCashMachineResult {
        val money = worldMoney[type]?.toMutableMap() ?: return GetCashMachineResult.InsufficientFunds
        val minNominal = money.keys.min()!!

        require(amount.rem(minNominal) == 0) { "Вводимая сумма должна делиться на ${minNominal}, т.к в банкомате это минимально возможная купюра" }

        val sortedNominals = money.keys.sortedByDescending { it }

        var currentAmount = amount
        val result = mutableMapOf<MoneyNominal, Int>()

        for (nominal in sortedNominals) {
            val nominalAmount = requireNotNull(money[nominal]) { "Количество валют должно быть" }

            if (nominal <= currentAmount && nominalAmount != 0) {
                currentAmount -= nominal
                money[nominal] = nominalAmount - 1
                result[nominal] = 1 + result.getOrDefault(nominal, 0)
            }
        }
        if (currentAmount > 0) return GetCashMachineResult.InsufficientFunds

        worldMoney[type] = money

        return GetCashMachineResult.Success(result)
    }

    internal fun getMoney(): Map<MoneyType, Map<MoneyNominal, Int>> {
        return worldMoney
    }
}

