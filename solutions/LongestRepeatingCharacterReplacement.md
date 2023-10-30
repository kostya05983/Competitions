We need to find longest substring containing same letter,
if we replace k replacements.

The solution to this problem is sliding window technique.

We move our window and save the highest frequency. Our window is
right-left+1-maxCount, we need to track maxCount, because we have to change
others characters to it. We extend our window, before it less k, if it become bigger than k,
we start to decrease it from left side, when we ended, we just take right-left+1 and count maxLength.

The answer will be maxLength.

## Code

```kotlin
   fun characterReplacement(s: String, k: Int): Int {
    var left = 0

    val frequencies = IntArray(26)
    var maxCount = 0
    var maxLength = 0

    for (right in s.indices) {
        maxCount = maxOf(maxCount, ++frequencies[s[right] - 'A'])

        while (right - left + 1 - maxCount > k) {
            frequencies[s[left] - 'A']--
            left++
        }
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}
```

## Example

AABABBA 1

First iteration A:

* frequencies A - 1
* maxLength = 2

Second iteration A

* frequencies A - 2
* maxCount = 2
* naxLength = 3

Third iteration B

* right = 2
* frequencies A-2, B-1
* maxCount = 2
* maxLength = 3

Fourh iteration A

* right = 3
* frequencies A-3, B-1
* maxCount = 3
* maxLength = 4

Fifth iteration B

* right = 4
* frequencies A-3, B-2
* maxCount = 3
* frequencies A-2, B-2
* left = 1
* maxLength = 4

Sixth iteration B

* right = 5
* frequencies A-2, B-3
* maxCount=3
* frequencies A-1 B-3
* left = 2
* maxLength = 4

Seventh iteration A

* right = 6
* frequencies A-2 B-3
* maxCount = 3
* frequencies A-1 B-3
* left = 3
* maxLength = 4


