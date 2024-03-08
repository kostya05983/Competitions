package easy

func maxFrequencyElements(nums []int) int {
	frequencies := make(map[int]int, 0)

	maxFrequency := 0
	totalFrequencies := 0
	for _, num := range nums {
		frequencies[num]++

		switch {
		case maxFrequency < frequencies[num]:
			maxFrequency = frequencies[num]
			totalFrequencies = frequencies[num]
		case maxFrequency == frequencies[num]:
			totalFrequencies += frequencies[num]
		}
	}

	return totalFrequencies
}
