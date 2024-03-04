package medium

import "sort"

func bagOfTokensScore(tokens []int, power int) int {
	sort.Ints(tokens)

	left := 0
	right := len(tokens) - 1
	score := 0

	result := 0

	for left <= right {
		if tokens[left] > power && score == 0 {
			return result
		}

		if tokens[left] <= power {
			power -= tokens[left]

			left++
			score++
			result = max(score, result)

			continue
		}

		if score > 0 {
			power += tokens[right]
			right--
			score--
		}
	}

	return result
}
