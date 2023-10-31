### Intuition

With cost[i] we buy time[i] and we can additionally finish time[i] walls
so we can finish time[i]+1 walls.


### Code
```kotlin
    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val dp = IntArray(cost.size + 1) { 1000000000 }
        dp[0] = 0

        for (i in time.indices)
            for (j in cost.size downTo 1) {
                dp[j] = minOf(dp[j], dp[maxOf(j - time[i] - 1, 0)] + cost[i])
            }

        return dp[cost.size]
    }
```


### Complexity
Time: O(n^2)
Space: O(n)

### Example
cost = [1,2,3,2] time = [1,2,3,2]

dp[0] = 0
i=0
dp[4] = minOf(1000000000, dp[maxOf(4-1-1,0)]+cost[0])=1000000000
dp[3] = minOf(1000000000, dp[maxOf(3-1-1,0)]+cost[0])=1000000000
dp[2] = minOf(1000000000, dp[maxOf(2-1-1,0)]+cost[0]) = 1
dp[1] = minOf(1000000000, dp[maxOf(1-1-1,0)]+cost[0]) = 1
i=1
dp[4] = minOf(1000000000, dp[maxOf(4-2-1, 0)]+cost[1]) = 3
dp[3] = minOf(1000000000, dp[maxOf(3-2-1, 0)]+cost[1]) = 2
dp[2] = minOf(1, dp[maxOf(2-2-1, 0)]+cost[1]) = 1
dp[1] = minOf(1, dp[maxOf(1-2-1, 0)]+cost[1]) = 1
i=2
dp[4] = minOf(3, dp[maxOf(4-3-1, 0)]+cost[2]) = 3
dp[3] = minOf(2, dp[maxOf(3-3-1,0)]+cost[2]) = 2
dp[2] = minOf(1, dp[maxOf(2-3-1,0)]+cost[2]) = 1
dp[1] = minOf(1, dp[maxOf(1-3-1, 0)]+cost[2]) = 1
i=3
dp[4] = minOf(3, dp[maxOf(4-2-1, 0)]+cost[3]) = 3
dp[3] = minOf(2, dp[maxOf(3-2-1, 0)]+cost[3]) =2
dp[2] = minOf(1, dp[maxOf(2-2-1,0)]+cost[3]) = 1
dp[1] = minOf(1, dp[maxOf(1-2-1,0)]+cost[3]) = 1

