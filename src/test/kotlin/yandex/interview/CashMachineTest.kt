package yandex.interview

import org.junit.jupiter.api.Test

internal class CashMachineTest {
    @Test
    fun `Банкомат пуст, получить отказ`() {
        val cacheMachine = CashMachine(
            listOf(
                Money(
                    MoneyType.RUBLE,
                    mapOf(
                        50 to 0, 100 to 0
                    )
                )
            )
        )

        val result = cacheMachine.get(1000, MoneyType.RUBLE)
        assert(result is GetCashMachineResult.InsufficientFunds)
    }

    @Test
    fun `Сумма несуразная`() {
        val cacheMachine = CashMachine(
            listOf(
                Money(
                    MoneyType.RUBLE,
                    mapOf(
                        50 to 0, 100 to 0
                    )
                )
            )
        )

        cacheMachine.get(1234, MoneyType.RUBLE)
    }

    @Test
    fun `кратно минимальному номиналу`() {
        val cacheMachine = CashMachine(
            listOf(
                Money(
                    MoneyType.RUBLE,
                    mapOf(
                        50 to 0, 100 to 1
                    )
                )
            )
        )

        val result = cacheMachine.get(50, MoneyType.RUBLE)
        require(result is GetCashMachineResult.InsufficientFunds)
    }

    @Test
    fun `В банкомате есть нужная сумма 1500, получить её `() {
        val cacheMachine = CashMachine(
            listOf(
                Money(
                    MoneyType.RUBLE,
                    mapOf(
                        500 to 1, 1000 to 1
                    )
                )
            )
        )

        val result = cacheMachine.get(1500, MoneyType.RUBLE)

        require(result is GetCashMachineResult.Success)

    }

    @Test
    fun `Два раза выдали денеги, на второй выдачи закончились`() {
        val cacheMachine = CashMachine(
            listOf(
                Money(
                    MoneyType.RUBLE,
                    mapOf(
                        500 to 1, 1000 to 1
                    )
                )
            )
        )

        val result = cacheMachine.get(1500, MoneyType.RUBLE)

        require(result is GetCashMachineResult.Success)
        val money = cacheMachine.getMoney()[MoneyType.RUBLE]
        require(money?.get(500) == 0)
        require(money?.get(1000) == 0)

        val result2 = cacheMachine.get(1000, MoneyType.RUBLE)
        require(result2 is GetCashMachineResult.InsufficientFunds)
    }
}