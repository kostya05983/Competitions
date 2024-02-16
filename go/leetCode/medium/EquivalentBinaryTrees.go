package medium

import "golang.org/x/tour/tree"
import "fmt"

// Walk walks the tree t sending all values
// from the tree to the channel ch.
func Walk(t *tree.Tree, ch chan int) {
	walk(t, ch)
	close(ch)

}

func walk(t *tree.Tree, ch chan int) {
	if t == nil {
		return
	}

	walk(t.Left, ch)
	ch<-t.Value
	walk(t.Right, ch)
}

// Same determines whether the trees
// t1 and t2 contain the same values.
func Same(t1, t2 *tree.Tree) bool {
	chLeft := make(chan int)
	chRight := make(chan int)

	go Walk(t1, chLeft)
	go Walk(t2, chRight)

	for  {
		left, leftOk := <-chLeft
		right, rightOk :=<-chRight

		if leftOk!=rightOk || left!=right {
			return false
		}

		if leftOk==false {
			break
		}
	}

	return true
}

func main() {
	fmt.Println(Same(tree.New(1), tree.New(1)))
	fmt.Println(Same(tree.New(1), tree.New(2)))
}