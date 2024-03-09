package easy

func getCommon(nums1 []int, nums2 []int) int {
	left := 0
	right := 0

	for left < len(nums1) && right < len(nums2) {
		switch {
		case nums1[left] < nums2[right]:
			left++
		case nums1[left] > nums2[right]:
			right++
		default:
			return nums1[left]
		}
	}

	return -1
}
