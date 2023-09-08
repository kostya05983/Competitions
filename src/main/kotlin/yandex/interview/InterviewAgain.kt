package yandex.interview

import java.util.Stack
import kotlin.random.Random


fun revert(str: String): String {
    val sb = StringBuilder()

    val stack = Stack<Char>()
    for (ch in str) {
        val diff = ch - 'A'
        if ((diff < 0 || diff > 26) && ch != ' ') throw IllegalArgumentException("Неверный входные данные")

        if (ch == ' ') {
            while (!stack.isEmpty()) {
                sb.append(stack.pop())
            }
            sb.append(ch)
        } else {
            stack.add(ch)
        }
    }
    while (!stack.isEmpty()) {
        sb.append(stack.pop())
    }

    return sb.toString()
}

fun main(args: Array<String>) {

}

class Randomizer {
    private val valueToIndex = mutableMapOf<Int, Int>()
    private val indexToValue = mutableMapOf<Int, Int>()
    private var size = 0

    fun add(value: Int) {
        if (valueToIndex.containsKey(value)) return

        valueToIndex.put(value, size)
        indexToValue.put(size, value)
        size++
    }

    fun contains(value: Int): Boolean {
        return valueToIndex.containsKey(value)
    }

    fun getRandom(): Int {
        require(size != 0) { "В рандомайзере нет чисел" }

        val randomIndex = Random.nextInt(0, size - 1)
        return indexToValue[randomIndex]!!
    }

    fun remove(value: Int) {
        val index = requireNotNull(valueToIndex[value]) { "Значение не существует" }

        if (index == size-1) {
            indexToValue.remove(index)
            valueToIndex.remove(value)
        } else {
            val lastValue = indexToValue[size-1]
            
            indexToValue.put(index, lastValue)
            valueToIndex.put(lastValue, index)
        }
        
        size--
    }
}
