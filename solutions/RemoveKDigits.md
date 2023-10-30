## Intuition

To minimize number we need to throw away numbers that greater than current, because we need the minimum start number.
Also, we can throw away number only if we have remainK.

For this problem we can use monotonic stack, you can find references here:
https://www.geeksforgeeks.org/introduction-to-monotonic-stack-data-structure-and-algorithm-tutorials/

We just add numbers there, if top number from stack is greater than current number, we pop it k times.

Then all we need to collect our stack to string

## Code

```kotlin
    fun removeKdigits(num: String, k: Int): String {
    val monotonicStack = Stack<Int>()

    var remainK = k

    for (ch in num) {
        val n = ch - '0'
        while (monotonicStack.isNotEmpty() && monotonicStack.peek() > n && remainK > 0) {
            monotonicStack.pop()
            remainK--
        }
        monotonicStack.push(n)
    }

    while (monotonicStack.isNotEmpty() && remainK > 0) {
        monotonicStack.pop()
        remainK--
    }

    if (monotonicStack.all { it == 0 }) return "0"

    return monotonicStack.joinToString("").dropWhile { it == '0' }
}
```

## Example

First, we add 1 to stack, our stack is 1
Then we met 4, one isn't greater than 4, we just add it to stack, our stack is 1,4, k=3
Then we met 3, 4 is greater than 3, we pop 4 and reduce k, then 1 isn't greater than 3, we add 3, our stack is 1,3, k=2
Then we met 2, 3 is greater than 2, we pop 3 and reduce k, then 1 isn't greater than 2, we add 2, out stack is 1,2, k=1
Then we met 2, 2 is equal to 2, we just add it, our stack is 1,2,2, k=1
Then we met 1, 2 is greater than 1, we pop 2 and reduce k, then 2 is greater than 1, but k is zero, so we just add 1 to
stack, our stack is 1,2,1, k=0
Then we met 9, our k is zero, we just add 9 to stack, our stack is 1, 2, 1, 9
And finally unite the stack, the answer is 1219
