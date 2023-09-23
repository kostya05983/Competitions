We need to remove two adjacent and equal letters from our string.
We have to stop our algorithm when we have no such letters at all in our string.

We can just go on str and save it to stringBuilder, when we meet char we compare it with previous, 
if they equal, we remove previous char from stringBuilder and continue. if they don't equal, we add this char to stringBuilder.

Time Complexity O(n), we have one loop on s
Space Complexity O(1), because we don't count result string

```kotlin
  fun removeDuplicates(s: String): String {
        val sb = StringBuilder()

        for (ch in s) {
            if (sb.getOrNull(sb.length - 1) == ch) {
                sb.deleteCharAt(sb.length - 1)
                continue
            }
            sb.append(ch)
        }

        return sb.toString()
    }
```
