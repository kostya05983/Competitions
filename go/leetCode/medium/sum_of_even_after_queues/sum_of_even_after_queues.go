package sum_of_even_after_queues

func sumEvenAfterQueries(nums []int, queries [][]int) []int {
	evenSum:=0

	for i:=range nums {
		if nums[i]%2==0 {
			evenSum+=nums[i]
		}
	}

	result:=make([]int, len(queries))

	for i := range queries {
		index:=queries[i][1]

		if nums[index] % 2 == 0 {
			evenSum-=nums[index]
		}

		nums[index]+=queries[i][0]
		if nums[index] % 2 == 0 {
			evenSum+=nums[index]
		}

		result[i] = evenSum
	}

	return result
}
