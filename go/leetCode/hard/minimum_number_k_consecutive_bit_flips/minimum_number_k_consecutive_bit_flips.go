package minimum_number_k_consecutive_bit_flips

func minKBitFlips(nums []int, k int) int {
	currentFlips := 0
	totalFlips := 0

	for i := range nums {
		if i >= k && nums[i-k] == 2 {
			currentFlips--
		}

		if (currentFlips % 2) == nums[i] {
			if i+k > len(nums) {
				return -1
			}
			nums[i] = 2
			currentFlips++
			totalFlips++
		}
	}

	return totalFlips
}
