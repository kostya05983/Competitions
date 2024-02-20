package easy

type void struct{}

var empty = void{}

func missingNumber(nums []int) int {
	set := make(map[int]void)

	for _, num := range nums {
		set[num] = empty
	}

	n := len(nums)

	for i := 0; i <= n; i++ {
		_, exists := set[i]
		if !exists {
			return i
		}
	}

	return -1
}
