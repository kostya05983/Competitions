package medium

func dailyTemperatures(temperatures []int) []int {
	var stack Stack

	var temperatureSize = len(temperatures)

	var result = make([]int, temperatureSize)

	for i := 0; i < len(temperatures); i++ {
		var temperature = temperatures[i]

		for !stack.IsEmpty() && temperatures[stack.Peek()] < temperature {
			var index, _ = stack.Pop()

			result[index] = i - index
		}
		stack.Push(i)
	}

	return result
}

type Stack []int

func (s *Stack) IsEmpty() bool {
	return len(*s) == 0
}

func (s *Stack) Push(value int) {
	*s = append(*s, value)
}

func (s *Stack) Peek() int {
	if s.IsEmpty() {
		return -1
	} else {
		index := len(*s) - 1
		element := (*s)[index]
		return element
	}
}

func (s *Stack) Pop() (int, bool) {
	if s.IsEmpty() {
		return -1, false
	} else {
		index := len(*s) - 1
		element := (*s)[index]
		*s = (*s)[:index]
		return element, true
	}
}
