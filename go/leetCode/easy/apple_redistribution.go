func minimumBoxes(apple []int, capacity []int) int {
    sort.Sort(sort.Reverse(sort.IntSlice(capacity)))

    left:=0
    right:=0

    for left<len(apple) {
        appleCount:=apple[left]


        for appleCount>0 {
            if capacity[right]>=appleCount {
                capacity[right]-=appleCount
                appleCount = 0
            } else {
                appleCount-=capacity[right]
                capacity[right] = 0
                right++
            }
        }
        left++
    }

    return right+1
}
