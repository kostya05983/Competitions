package sum_all_subset_xor_total

func subsetXORSum(nums []int) int {
	return recursvie(0, 0, nums)
}

func recursvie(i int, sum int, nums []int) int {
	if i >= len(nums) {
		return 0
	}
	skip := recursvie(i+1, sum, nums)
	include := recursvie(i+1, sum^nums[i], nums)

	return skip + include
}
