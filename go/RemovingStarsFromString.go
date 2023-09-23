package main

import "fmt"

func removeStars(s string) string {
	var sb []rune

	for _, ch := range s {
		switch ch {
		case '*':
			sb = sb[:len(sb)-1]
		default:
			sb = append(sb, ch)
		}
	}

	return string(sb)
}

func main() {
	fmt.Printf("example1 %s", removeStars("leet**cod*e"))
}
