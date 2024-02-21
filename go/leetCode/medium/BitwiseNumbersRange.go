package medium

import (
	"fmt"
	"strconv"
	"strings"
)

func rangeBitwiseAnd(left int, right int) int {
	leftBinary := toBinary(left)
	rightBinary := toBinary(right)

	binary := ""
	for i, value := range leftBinary {
		if value != rightBinary[i] {
			binary += strings.Repeat("0", len(leftBinary)-i)
			break
		}
		binary += fmt.Sprintf("%d", value)
	}

	result, _ := strconv.ParseInt(binary, 2, 64)

	return int(result)
}

func toBinary(num int) []int {
	result := make([]int, 64)

	i := 0
	for num > 0 {
		result[i] = num % 2
		num /= 2
		i++
	}

	return reverseInts(result)
}

func reverseInts(nums []int) []int {
	n := len(nums)
	result := make([]int, n)

	for i, v := range nums {
		result[n-i-1] = v
	}

	return result
}
