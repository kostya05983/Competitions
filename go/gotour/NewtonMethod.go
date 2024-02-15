package gotour

import (
	"fmt"
	"math"
)

func Sqrt(x float64) float64 {
	result := x
	z := float64(x / 2)
	tolerance := 0.01

	for i := 0; i < 100; i++ {
		z -= (z*z - x) / (2 * z)
		fmt.Println(z)

		if math.Abs(result-z) <= tolerance {
			return result
		}

		result = min(result, z)
	}

	return result
}

func main() {
	fmt.Println(Sqrt(64))
}
