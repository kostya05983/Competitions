
### Approach

You can skip next i items after purchase, 
it means that we can move from i+1 to 2i+1 items and try taking each of them.
Record min value of each move.
Add ith price to min possible and return dp

### Code
```kotlin
    fun minimumCoins(prices: IntArray): Int {
        val dp = IntArray(1001)
    
        return buyNext(0, prices, dp) 
    }

    private fun buyNext(i: Int, prices: IntArray, dp: IntArray): Int {
        if (i >= prices.size) return 0
        if (dp[i] != 0) return dp[i]
    
        var min = Int.MAX_VALUE
        for (j in i + 1..2 * i + 2) {
            val nextPrice = buyNext(j, prices, dp)
            min = minOf(min, nextPrice)
        }
    
        dp[i] = min + prices[i]
    
        return dp[i]
    }
```

### Complexity
???

### Example
[1,10,1,1]

For i=0

For j in 1..2 call buyNext

dp[0] = 1+1 = 2

For i=1

For j in 2..4 call buyNext

dp[1] = 10

For i=2

For j in 3..6 call buyNext

dp[2] = 0+1=1

For i=3

For j in 4..8 call buyNext

dp[3] = 0+1 = 1

There is unnecessary calls when range exceeds array size, we can optimize this.