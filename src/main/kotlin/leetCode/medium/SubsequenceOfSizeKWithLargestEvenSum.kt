package leetCode.medium

class SubsequenceOfSizeKWithLargestEvenSum {
    fun largestEvenSum(nums: IntArray, k: Int): Long {
        val evenNumbers = mutableListOf<Int>()
        val oddNumbers = mutableListOf<Int>()

        for (num in nums) {
            if (num.rem(2) == 0) {
                evenNumbers.add(num)
            } else {
                oddNumbers.add(num)
            }
        }

        evenNumbers.sort()
        oddNumbers.sort()

        var remK = k
        var evenNumberPointer = evenNumbers.lastIndex
        var oddNumberPointer = oddNumbers.lastIndex

        var sum = 0L
        while (evenNumberPointer >= 0 || oddNumberPointer >= 0) {
            if (evenNumberPointer >= 0 && oddNumberPointer >= 0) {
                if (evenNumbers[evenNumberPointer] > oddNumbers[oddNumberPointer]) {
                    sum += evenNumbers[evenNumberPointer]
                    evenNumberPointer--
                } else {
                    sum += oddNumbers[oddNumberPointer]
                    oddNumberPointer--
                }
            } else if (evenNumberPointer >= 0) {
                sum += evenNumbers[evenNumberPointer]
                evenNumberPointer--
            } else {
                sum += oddNumbers[oddNumberPointer]
                oddNumberPointer--
            }
            remK--
            if (remK == 0) break
        }
        if (sum.rem(2) == 0L) return sum

        var result = Long.MIN_VALUE

        if (evenNumberPointer >= 0 && oddNumberPointer + 1 < oddNumbers.size)
            result = sum - oddNumbers[oddNumberPointer + 1] + evenNumbers[evenNumberPointer]
        if (oddNumberPointer >= 0 && evenNumberPointer + 1 < evenNumbers.size)
            result = maxOf(result, sum - evenNumbers[evenNumberPointer + 1] + oddNumbers[oddNumberPointer])

        return if (result == Long.MIN_VALUE) -1 else result
    }
}

fun main(args: Array<String>) {
    val solution = SubsequenceOfSizeKWithLargestEvenSum()
    println(solution.largestEvenSum(intArrayOf(4, 1, 5, 3, 1), 3))
    println(solution.largestEvenSum(intArrayOf(4, 6, 2), 3))
    println(solution.largestEvenSum(intArrayOf(1, 3, 5), 1))
    println(solution.largestEvenSum(intArrayOf(2, 1, 1), 2))
    println(solution.largestEvenSum(intArrayOf(20, 20, 3, 1, 12, 10, 3, 7, 6, 6), 9))
}