package minimum_number_of_days_make_bouquets

type Flower struct {
	index    int
	bloomDay int
}

func minDays(bloomDay []int, m int, k int) int {
	start := 0
	end := 0

	for _, day := range bloomDay {
		end = max(end, day)
	}

	result := -1
	for start <= end {
		mid := (start + end) / 2

		if numberOfBouquets(bloomDay, mid, k) >= m {
			result = mid
			end = mid - 1
		} else {
			start = mid + 1
		}
	}

	return result
}

func numberOfBouquets(bloomDay []int, day int, k int) int {
	bouquetsAmount := 0
	count := 0

	for i := 0; i < len(bloomDay); i++ {
		if bloomDay[i] <= day {
			count++
		} else {
			count = 0
		}

		if count == k {
			bouquetsAmount++
			count = 0
		}
	}

	return bouquetsAmount
}
