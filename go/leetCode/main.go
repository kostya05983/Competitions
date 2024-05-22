package main

import "fmt"
import "./medium/palindrome_partitioning"

func main() {
	result := palindrome_partitioning.Partition("abbab")
	fmt.Println(result)
}
