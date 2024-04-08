package easy

func countStudents(students []int, sandwiches []int) int {
	countStudents := []int{0, 0}

	for _, student := range students {
		countStudents[student]++
	}

	for i, sandwich := range sandwiches {
		if countStudents[sandwich] == 0 {
			return len(sandwiches) - i
		}
		countStudents[sandwich]--
	}

	return 0
}
