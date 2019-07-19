package structures

import java.lang.StringBuilder
import kotlin.math.max


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
        var height: Int = 1

        constructor(value: T) {
            this.value = value
            this.height = 1
        }

        constructor(left: Node<T>?, right: Node<T>?, value: T, height: Int) {
            this.leftChild = left
            this.rightChild = right
            this.value = value
            this.height = height
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
        return root.height
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

        z.height = maxOf(height(z.leftChild), height(z.rightChild)) + 1
        y.height = maxOf(height(y.leftChild), height(y.rightChild)) + 1

        return y
    }

    private fun leftRotate(z: Node<T>): Node<T> {
        val y = z.rightChild
        val t2 = y?.leftChild

        y!!.leftChild = z
        z.rightChild = t2

        z.height = maxOf(height(z.leftChild), height(z.rightChild)) + 1
        y.height = maxOf(height(y.leftChild), height(y.rightChild)) + 1
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

        //2. after standard insert, update  height
        node.height = 1 + max(height(node.leftChild), height(node.rightChild))

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
                node.leftChild = delete(node.leftChild, value)
            }
            value > node.value -> { // searching value in right subtree
                node.rightChild = delete(node.rightChild, value)
            }
            else -> { //Yea we find value
                return if (node.leftChild == null && node.rightChild == null) {
                    null
                } else if (node.leftChild == null) {
                    node.rightChild
                } else if (node.rightChild == null) {
                    node.leftChild
                } else {
                    val minValue = minValue(node.rightChild!!)
                    Node(node.leftChild, delete(node.rightChild, minValue), minValue, node.height)
                }
            }
        }

        node.height = max(height(node.leftChild), height(node.rightChild)) + 1

        val balanced = getBalance(node)

        //left left case
        if (balanced > 1 && getBalance(node.leftChild) >= 0) {
            return rightRotate(node)
        }
        // right right case
        if (balanced < -1 && getBalance(node.rightChild) <= 0) {
            return leftRotate(node)
        }
        // left right case
        if (balanced > 1 && getBalance(node.rightChild) < 0) {
            node.leftChild = leftRotate(node.leftChild!!)
            return rightRotate(node)
        }
        // right left case
        if (balanced < -1 && getBalance(node.leftChild) > 0) {
            node.rightChild = rightRotate(node.rightChild!!)
            return leftRotate(node)
        }
        return node
    }

    private fun minValue(root: Node<T>): T {
        val tmp = root.leftChild
        if (tmp != null) {
            return minValue(tmp)
        }
        return root.value
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