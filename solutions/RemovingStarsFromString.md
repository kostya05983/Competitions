We have s which contains stars "*". And we need to remove all stars, but when we delete start we remove the nearest char too.
We know that when we need to remove char there is always left char before star by conditions.
So we need just when we meet star remove previous char and skip star.

In java for this we can use string builder, and in go we can use just array of runes.

```kotlin
fun removeStars(s: String): String {
        val sb = StringBuilder()

        for (ch in s) {
            when (ch) {
                '*' -> sb.deleteCharAt(sb.length - 1)
                else -> sb.append(ch)
            }
        }

        return sb.toString()
    }
```

```go
func removeStars(s string) string {
	var sb []rune

	for _, ch := range s {
		switch ch {
		case '*':
			sb = sb[:len(sb)-1]
		default:
			sb = append(sb, ch)
		}
	}

	return string(sb)
}
```