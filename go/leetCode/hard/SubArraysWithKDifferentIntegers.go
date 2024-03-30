package hard

func subarraysWithKDistinct(nums []int, k int) int {
	set := make(map[int]int, 0)

	left := 0
	right := 0
	n := len(nums)
	result := 0

	for ; right < n; right++ {
		num := nums[right]
		set[num]++

		if len(set) == k {
			nextBoard := nextIncreased(right, nums, set)

			for len(set) == k {
				result += nextBoard - right + 1

				leftNum := nums[left]
				set[leftNum]--

				if set[leftNum] == 0 {
					delete(set, leftNum)
				}
				left++
			}
		}
	}

	return result
}

func nextIncreased(right int, nums []int, set map[int]int) int {
	for ; right < len(nums); right++ {
		num := nums[right]

		_, ok := set[num]
		if !ok {
			return right
		}
	}

	return len(nums)
}
