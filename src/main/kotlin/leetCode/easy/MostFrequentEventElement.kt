package leetCode.easy

class MostFrequentEventElement {
    fun mostFrequentEven(nums: IntArray): Int {
        val frequency = mutableMapOf<Int, Int>()

        for (element in nums) {
            val isEven = element.rem(2) == 0

            if (!isEven) continue

            frequency[element] = frequency.getOrDefault(element, 0) + 1
        }

        val result = frequency.maxBy {
            it.value
        } ?: return -1

        var minByKey = result.key
        for (element in frequency) {
            if (element.value == result.value) {
                minByKey = minOf(minByKey, element.key)
            }
        }

        return minByKey
    }
}

fun main(args: Array<String>) {
    println(MostFrequentEventElement().mostFrequentEven(intArrayOf(0, 1, 2, 2, 4, 4, 1)))
    println(MostFrequentEventElement().mostFrequentEven(intArrayOf(4, 4, 4, 9, 2, 4)))
    println(MostFrequentEventElement().mostFrequentEven(intArrayOf(29, 47, 21, 41, 13, 37, 25, 7)))
    println(MostFrequentEventElement().mostFrequentEven(intArrayOf(8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290)))
}