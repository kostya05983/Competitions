package medium

func bestClosingTime(customers string) int {
	n := len(customers)

	counterCome := 0
	countCome := make([]int, n)

	counterNo := 0
	countNo := make([]int, n)

	for i, ch := range customers {
		if ch == 'Y' {
			counterCome++
		} else {
			counterNo++
		}
		countCome[i] = counterCome
		countNo[i] = counterNo
	}

	minHour := 0
	minPenalty := n

	for i := range customers {
		var openPenalty int
		if i == 0 {
			openPenalty = 0
		} else {
			openPenalty = countNo[i-1]
		}

		var closePenalty int
		if i == 0 {
			closePenalty = counterCome
		} else {
			closePenalty = counterCome - countCome[i-1]
		}
		commonPenalty := openPenalty + closePenalty

		if commonPenalty < minPenalty {
			minPenalty = min(commonPenalty, minPenalty)
			minHour = i
		}
	}
	if counterNo < minPenalty {
		minPenalty = min(minPenalty, counterNo)
		minHour = n
	}

	return minHour
}
