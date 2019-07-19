package structures

import java.lang.StringBuilder


/**
 * Avl tree
 *
 * Min max insert, delete O(H) where h is the height of bst tree
 * The height of avl tree is always O(Logn)
 */
class AVLTree<T : Comparable<T>> {

    private var root: Node<T>? = null

    private class Node<T : Comparable<T>> {
        var leftChild: Node<T>? = null
        var rightChild: Node<T>? = null
        val value: T

        constructor(value: T) {
            this.value = value
        }
    }

    /**
     * Public fun for user to get height of tree
     */
    fun height(): Int {
        return height(root)
    }

    /**
     * Find the height of subtree or all tree
     */
    private fun height(root: Node<T>?): Int {
        if (root == null) {
            return 0
        }
        return 1 + if (root.leftChild != null) height(root.leftChild) else height(root.rightChild)
    }

    /**
     * Get balance of tree to understand next step of balance
     */
    private fun getBalance(node: Node<T>?): Int {
        if (node == null) {
            return 0
        }
        return height(node.leftChild) - height(node.rightChild)
    }

    private fun rightRotate(z: Node<T>): Node<T> {
        val y = z.leftChild
        val t2 = y?.rightChild

        y!!.rightChild = z
        z.leftChild = t2
        return y
    }

    private fun leftRotate(z: Node<T>): Node<T> {
        val y = z.rightChild
        val t2 = y?.leftChild

        y!!.leftChild = z
        z.rightChild = t2
        return y
    }

    fun insert(value: T) {
        root = insert(root, value)
    }

    /**
     * In insertion to re-balance we use rotation
     */
    private fun insert(node: Node<T>?, value: T): Node<T> {
        if (node == null) { // if it first insert nprmal bst insertion
            return Node(value)
        }

        when {
            value < node.value -> node.leftChild = insert(node.leftChild, value)
            value > node.value -> node.rightChild = insert(node.rightChild, value)
            else -> return node
        }

        val balanced = getBalance(node)

        //left left case
        if (balanced > 1 && node.leftChild != null && value < node.leftChild!!.value) {
            return rightRotate(node)
        }
        // right right case
        if (balanced < -1 && node.rightChild != null && value > node.rightChild!!.value) {
            return leftRotate(node)
        }
        // left right case
        if (balanced > 1 && node.leftChild != null && value > node.leftChild!!.value) {
            node.leftChild = leftRotate(node.leftChild!!)
            return rightRotate(node)
        }
        // right left case
        if (balanced < -1 && node.rightChild != null && value < node.rightChild!!.value) {
            node.rightChild = rightRotate(node.rightChild!!)
            return leftRotate(node)
        }

        return node
    }

    fun delete(value: T) {
        root = delete(root, value)
    }

    private fun delete(node: Node<T>?, value: T): Node<T>? {
        if (node == null) { //tree is empty
            return node
        }



        when {
            value < node.value -> { //searching value in left subtree

            }
            value > node.value -> { // searching value in right subtree

            }
            else ->  { //Yea we find value

            }
        }

        return node
    }


    /**
     * Preorder travel in tree
     */
    private fun preOrder(root: Node<T>?, sb: StringBuilder) {
        if (root != null) {
            sb.append(root.value).append(" ")
            preOrder(root.leftChild, sb)
            preOrder(root.rightChild, sb)
        }
    }

    fun preOrder(): String {
        val sb = StringBuilder()
        preOrder(root, sb)
        return sb.toString()
    }
}