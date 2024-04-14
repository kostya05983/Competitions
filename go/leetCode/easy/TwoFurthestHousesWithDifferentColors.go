package easy

func maxDistance(colors []int) int {
	result := 0
	for i, color := range colors {
		for j, colorJ := range colors {
			if color != colorJ {
				result = max(j-i, result)
			}
		}
	}

	return result
}
