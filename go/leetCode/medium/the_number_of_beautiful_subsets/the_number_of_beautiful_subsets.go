package the_number_of_beautiful_subsets

import "sort"

func beautifulSubsets(nums []int, k int) int {
	sort.Ints(nums)
	return traverse(0, nums, map[int]struct{}{}, k) - 1
}

func traverse(i int, nums []int, current map[int]struct{}, k int) int {
	if i == len(nums) {
		return 1
	}

	skip := traverse(i+1, nums, current, k)

	_, ok := current[nums[i]-k]
	include := 0
	if !ok {
		current[nums[i]] = struct{}{}
		include = traverse(i+1, nums, current, k)
		delete(current, nums[i])
	}

	return skip + include
}
