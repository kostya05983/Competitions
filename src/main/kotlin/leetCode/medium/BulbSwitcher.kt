package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

class BulbSwitcher {
    fun bulbSwitch(n: Int): Int {
        return sqrt(n.toDouble()).toInt()
    }

    fun bulbSwitch2(n: Int): Int {
        val divisorsMap = mutableMapOf<Int, Set<Int>>()

        for (i in 1 until n + 1) {
            val res = findDevisers(i)
            println("Результат для $i $res")
            divisorsMap[i] = res
        }

        var result = 0
        for (entry in divisorsMap) {
            if (entry.value.size.rem(2) != 0) result++
        }

        return result
    }

    private val memory = mutableMapOf<Int, Set<Int>>()

    private fun findDevisers(n: Int): Set<Int> {
        val result = mutableSetOf<Int>()
        var i = 1

        val sqrtRes = sqrt(n.toDouble())
        while (i <= sqrtRes) {
            if (n.rem(i) == 0) {
                result.add(i)

                val divided = n / i

                val memorized = memory[divided]
                if (memorized != null) {
                    result.addAll(memorized)
                    result.addAll(memorized.asSequence().map { it * i })
                    memory[n] = result

                    return result
                }

                if (divided != i) {
                    result.add(divided)
                }
            }
            i++
        }

        memory[n] = result
        return result
    }
}

fun main(args: Array<String>) {
    val solution = BulbSwitcher()
    val example1 = solution.bulbSwitch(3)
    assertEquals(1, example1)

    val example2 = solution.bulbSwitch(0)
    assertEquals(0, example2)

    val example3 = solution.bulbSwitch(1)
    assertEquals(1, example3)

    val example5 = solution.bulbSwitch(100)
    println(example5)

    val example6 = measureTimeMillis {
        solution.bulbSwitch(100)
    }

    println(example6)
}