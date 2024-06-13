package minumum_number_of_moves_to_seat_everyone

import (
	"sort"
)

func minMovesToSeat(seats []int, students []int) int {
	sort.Ints(seats)
	sort.Ints(students)

	result := 0

	for i, student := range students {
		if seats[i]-student < 0 {
			result += student - seats[i]
		} else {
			result += seats[i] - student
		}
	}

	return result
}
