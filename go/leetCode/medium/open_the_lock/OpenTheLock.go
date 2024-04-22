package open_the_lock

import (
	"math"
)

var nextChar = map[rune]rune{
	'0': '1',
	'1': '2',
	'2': '3',
	'3': '4',
	'4': '5',
	'5': '6',
	'6': '7',
	'7': '8',
	'8': '9',
	'9': '0',
}
var prevChar = map[rune]rune{
	'0': '9',
	'1': '0',
	'2': '1',
	'3': '2',
	'4': '3',
	'5': '4',
	'6': '5',
	'7': '6',
	'8': '7',
	'9': '8',
}

func openLock(deadends []string, target string) int {
	visited := make(map[string]bool, 10000)
	for i := range deadends {
		visited[deadends[i]] = true
	}

	if visited["0000"] {
		return -1
	}

	visited["0000"] = true

	result := -1

	queue := make([][]rune, 0)
	queue = append(queue, []rune{'0', '0', '0', '0'})

	score := 0

	for len(queue) > 0 {
		n := len(queue)
		for j := 0; j < n; j++ {
			current := queue[0]
			queue = queue[1:]

			currentStr := string(current)
			if currentStr == target {
				return score
			}

			for i := 0; i < 4; i++ {
				temp := make([]rune, len(current))
				copy(temp, current)
				temp[i] = nextChar[temp[i]]
				tempStr := string(temp)

				if !visited[tempStr] {
					queue = append(queue, temp)
					visited[tempStr] = true
				}

				tempPrev := make([]rune, len(current))
				copy(tempPrev, current)
				tempPrev[i] = prevChar[tempPrev[i]]
				tempPrevStr := string(tempPrev)

				if !visited[tempPrevStr] {
					queue = append(queue, tempPrev)
					visited[tempPrevStr] = true
				}
			}
		}
		score++
	}

	if result == math.MaxInt {
		return -1
	} else {
		return result
	}
}
