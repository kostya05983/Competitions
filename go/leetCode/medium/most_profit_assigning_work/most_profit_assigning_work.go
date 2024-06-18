package most_profit_assigning_work

import "sort"

type Job struct {
	difficult int
	profit    int
}

func maxProfitAssignment(difficulty []int, profit []int, worker []int) int {
	sort.Ints(worker)

	jobs := make([]Job, 0)

	for i := range difficulty {
		jobs = append(jobs, Job{difficulty[i], profit[i]})
	}

	sort.Slice(jobs, func(i, j int) bool {
		return jobs[i].profit < jobs[j].profit
	})

	jobPointer := len(jobs) - 1
	workerPointer := len(worker) - 1

	result := 0
	for workerPointer >= 0 && jobPointer >= 0 {
		if worker[workerPointer] >= jobs[jobPointer].difficult {
			result += jobs[jobPointer].profit
			workerPointer--
		} else {
			jobPointer--
		}
	}

	return result
}
