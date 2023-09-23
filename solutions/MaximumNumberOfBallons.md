We need to find how much words we can build from out string. For this goal, we need to count 
frequencies of each letter in our string. Then we need to know how letters of each type we need to build our string.

Then we need to find the minimum frequency of letter we need in the word we wanted.

Time O(n)
Space O(1), because we have alphabet 26 and it's constant

code in golang
```go
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
```
