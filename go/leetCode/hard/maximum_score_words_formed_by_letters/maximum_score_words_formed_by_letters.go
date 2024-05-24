package maximum_score_words_formed_by_letters

func maxScoreWords(words []string, letters []byte, score []int) int {
	lettersMap:=make(map[byte]int, 0)

	for i:=range letters {
		lettersMap[letters[i]]++
	}

	return traverse(0, words, lettersMap, score, 0)
}


func traverse(i int, words []string, lettersMap map[byte]int, score []int, currentScore int) int {
	if i == len(words) {
		return currentScore
	}

	word:=words[i]

	newScore:=currentScore
	enoughLetters := true

	newLettersMap:=make(map[byte]int, 0)
	maps.Copy(newLettersMap, lettersMap)

	for _,ch:=range word {
		frequency, _:=newLettersMap[byte(ch)]

		if frequency == 0 {
			enoughLetters=false
			break
		}

		if frequency>0 {
			newLettersMap[byte(ch)]--
			newScore += score[ch-'a']
		}
	}

	include:=0
	if enoughLetters {
		include = traverse(i+1, words, newLettersMap, score, newScore)
	}

	skip:=traverse(i+1, words, lettersMap, score, currentScore)

	return max(include, skip)
}