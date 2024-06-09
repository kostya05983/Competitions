package sum_divisible_by_k

// 4,5,0,-2,-3,1
func subarraysDivByK(nums []int, k int) int {
	result := 0

	temp := make(map[int]int, 0)
	temp[0] = 1

	sum := 0
	for i := range nums {
		sum = (sum + nums[i]%k + k) % k

		result += temp[sum]
		temp[sum]++
	}

	return result
}
