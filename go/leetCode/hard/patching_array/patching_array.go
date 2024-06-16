package patching_array

func minPatches(nums []int, n int) int {
	var obtain int64 = 1
	result := 0
	i:=0

	for obtain<=int64(n) {
		if i < len(nums) && int64(nums[i]) <=obtain {
			obtain+=int64(nums[i])
			i++
		} else {
			obtain+=obtain
			result++
		}
	}
	return result
}