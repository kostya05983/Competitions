package count_triplets_that_can_form_two_arays

func countTriplets(arr []int) int {
	left := 0
	right := 1

	xor := 0
	result := 0

	for left < len(arr) {
		xor = arr[left]
		right = left + 1
		for right < len(arr) {
			xor = xor ^ arr[right]

			if xor == 0 {
				result += (right - left) - 1
			}
			right++
		}
		left++
	}

	return result
}
