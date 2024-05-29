package find_the_kth_lucky_number

import "slices"

func kthLuckyNumber(k int) string {
	binary := make([]int, 0)

	k++
	for k > 0 {
		binary = append(binary, k%2)
		k /= 2
	}
	slices.Reverse(binary)
	binary = binary[1:]

	result := make([]rune, len(binary))

	for i := range binary {
		if binary[i] == 1 {
			result[i] = '7'
		} else {
			result[i] = '4'
		}
	}

	return string(result)
}
