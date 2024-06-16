package minimum_number_of_coins

import "sort"

func minimumAddedCoins(coins []int, target int) int {
	sort.Ints(coins)

	obtain := 0
	result := 0

	for i := 0; i < len(coins) && obtain < target; i++ {
		for obtain+1 < coins[i] {
			obtain += obtain + 1
			result++
		}
		obtain += coins[i]
	}
	for obtain < target {
		obtain += obtain + 1
		result++
	}
	return result
}
