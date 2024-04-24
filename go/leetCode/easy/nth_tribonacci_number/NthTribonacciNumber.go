package nth_tribonacci_number

func tribonacci(n int) int {
	if n == 0 {
		return 0
	}
	if n == 1 || n == 2 {
		return 1
	}

	first := 0
	second := 1
	third := 1

	for n > 2 {
		temp := third + second + first
		first = second
		second = third
		third = temp
		n--
	}

	return third
}
