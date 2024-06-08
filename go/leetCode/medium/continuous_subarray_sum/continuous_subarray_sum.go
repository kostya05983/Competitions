package continuous_subarray_sum

func checkSubarraySum(nums []int, k int) bool {
	tmp := make(map[int]bool, 0)

	prefixSum := 0
	for i, num := range nums {
		tmp[num] = true
		prefixSum += num

		remainder := prefixSum % k
		if remainder == 0 || tmp[remainder] || num == 0 && i >= 1 {
			return true
		}
	}

	return false
}
