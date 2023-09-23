package main

import (
	"fmt"
	"math"
)

func maxNumberOfBalloons(text string) int {
	var frequencies map[uint8]int
	frequencies = make(map[uint8]int)

	for i := 0; i < len(text); i++ {
		frequencies[text[i]] = frequencies[text[i]] + 1
	}

	var word = "balloon"
	var minValue = math.MaxInt32

	for i := 0; i < len(word); i++ {
		var frequency = frequencies[word[i]]
		if word[i] == 'l' || word[i] == 'o' {
			minValue = min(minValue, frequency/2)
		} else {
			minValue = min(minValue, frequency)
		}
	}

	return minValue
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	fmt.Printf("example1 %d \n", maxNumberOfBalloons("nlaebolko"))
	fmt.Printf("example2 %d \n", maxNumberOfBalloons("loonbalxballpoon"))
	fmt.Printf("example3 %d \n", maxNumberOfBalloons("leetcode"))
}
