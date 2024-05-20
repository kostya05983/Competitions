package number_of_spaces_cleaning

import "fmt"

func numberOfCleanRooms(room [][]int) int {
	result := 0

	x := 0
	y := 0

	//0 right, 1 - down, 2 - left, 3 - up
	direction := 0

	turnPoints := make(map[string]struct{}, 0)

	for true {
		if room[y][x] == 0 {
			result++
		}

		room[y][x] = -1

		key := fmt.Sprintf("%d:%d:%d", y, x, direction)

		_, ok := turnPoints[key]
		if ok {
			return result
		}

		var previous = direction
		turns := 0
		for turns < 5 {
			newDirection := changeDirectionOrNot(room, x, y, direction)
			previous = direction
			direction = newDirection

			if previous == newDirection {
				break
			} else {
				turnPoints[key] = struct{}{}
			}
			turns++
		}
		//cycle
		if turns == 5 {
			break
		}

		switch direction {
		case 0:
			x++
		case 1:
			y++
		case 2:
			x--
		default:
			y--
		}
	}

	return result
}

func changeDirectionOrNot(room [][]int, x, y int, direction int) int {
	switch {
	case direction == 0 && (x == len(room[0])-1 || room[y][x+1] == 1):
		direction++
		direction = direction % 4
		return direction
	case direction == 1 && (y == len(room)-1 || room[y+1][x] == 1):
		direction++
		direction = direction % 4
		return direction
	case direction == 2 && (x == 0 || room[y][x-1] == 1):
		direction++
		direction = direction % 4
		return direction
	case direction == 3 && (y == 0 || room[y-1][x] == 1):
		direction++
		direction = direction % 4
		return direction
	}

	return direction
}
