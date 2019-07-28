package structures

class SplayTree<T : Comparable<T>> {

    private var root: Node<T>? = null

    private class Node<T> {
        var leftChild: Node<T>? = null
        var rightChild: Node<T>? = null
        val value: T

        constructor(value: T) {
            this.value = value
        }
    }

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun splay(root: Node<T>?, value: T): Node<T>? {
        var root = root
        if (root == null || root.value == value) {
            return root
        }

        // if value lies in left subtree
        if (root.value > value) {
            //key is not in tree we are done
            if (root.leftChild == null) return root

            //Zig zig left left
            if (root.leftChild!!.value > value) {
                root.leftChild!!.leftChild = splay(root.leftChild!!.leftChild, value)

                root = rightRotate(root)
            } else { //Zig zag left right

                root.leftChild!!.rightChild = splay(root.leftChild!!.rightChild, value)

                if (root.leftChild!!.rightChild != null) {
                    root.leftChild = leftRotate(root.leftChild!!)
                }
            }

            return if (root!!.leftChild == null) {
                root
            } else {
                rightRotate(root)
            }
            //if value lies in right subtree
        } else {
            if (root.rightChild == null) {
                return root
            }

            if (root.rightChild!!.value > value) { //right left Zag zig
                root.rightChild!!.leftChild = splay(root.rightChild!!.leftChild, value)

                if (root.rightChild!!.leftChild != null) {
                    root.rightChild = rightRotate(root.rightChild!!)
                }
            } else { // right right zag zag
                root.rightChild!!.rightChild = splay(root.rightChild!!.rightChild, value)
                root = leftRotate(root)
            }
            return if (root!!.rightChild == null) {
                root
            } else {
                leftRotate(root)
            }
        }
    }

    private fun leftRotate(root: Node<T>): Node<T>? {
        val rightChild = root.rightChild
        root.rightChild = rightChild?.leftChild
        rightChild?.leftChild = root
        return rightChild
    }

    private fun rightRotate(root: Node<T>): Node<T>? {
        val leftChild = root.leftChild
        root.leftChild = leftChild?.rightChild
        leftChild?.rightChild = root
        return leftChild
    }

    /**
     * @param node - node to insert
     * @param value - value to insert in splay tree
     * @return - new root
     */
    private fun insert(node: Node<T>?, value: T): Node<T> {
        if (node == null) return Node(value)

        if (node.value == value) {
            return node
        }

        val closestNode = splay(root, value)

        if (closestNode!!.value == value) {
            return closestNode
        }

        val newNode = Node(value)

        if (closestNode.value > value) {
            newNode.rightChild = closestNode
            newNode.leftChild = closestNode.leftChild
            closestNode.leftChild = null
        } else {
            newNode.leftChild = closestNode
            newNode.rightChild = closestNode.rightChild
            closestNode.rightChild = null
        }

        return newNode
    }


}