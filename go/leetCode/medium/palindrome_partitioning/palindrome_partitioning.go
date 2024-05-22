package palindrome_partitioning

func Partition(s string) [][]string {
	return partition(s)
}

func IsPalindromic(value string) bool {
	return isPalidromic(value)
}

func partition(s string) [][]string {
	result := make([][]string, 0)

	traverse(0, s, []uint8{}, []string{}, &result)

	return result
}

func traverse(i int, s string, current []uint8, currentArr []string, result *[][]string) {
	if i == len(s) {
		length := isAllPalindromic(currentArr)
		if length == len(s) {
			*result = append(*result, currentArr)
		}
		return
	}

	newCurrent := append(current, s[i])

	//split
	newSlice := append([]string{}, currentArr...)
	newSlice = append(newSlice, string(newCurrent))
	traverse(i+1, s, []uint8{}, newSlice, result)

	//continue
	traverse(i+1, s, newCurrent, currentArr, result)
}

func isAllPalindromic(strings []string) int {
	count := 0
	for i := range strings {
		if !isPalidromic(strings[i]) {
			return 0
		}
		count += len(strings[i])
	}
	return count
}

func isPalidromic(value string) bool {
	left := 0
	right := len(value) - 1

	for left < len(value) && right > 0 && left <= right {
		if value[left] != value[right] {
			return false
		}
		left++
		right--
	}

	return true
}
