package structures

import java.lang.StringBuilder
import kotlin.math.max


class RedBlackTree<T : Comparable<T>> {
    private var root: Node<T>? = null
    private var blackHeight = 0
    private var whiteHeight = 0

    fun height(): Int {
        return height(root)
    }

    private fun height(root: Node<T>?): Int {
        if (root == null) {
            return 0
        }
        return root.height
    }

    private class Node<T> {
        var left: Node<T>? = null
        var right: Node<T>? = null
        var isRed: Boolean = false
        var value: T
        var height: Int = 1

        constructor(value: T) {
            this.value = value
        }

        constructor(value: T, isRed: Boolean) {
            this.value = value
            this.isRed = isRed
        }
    }

    private fun getBalance(node: Node<T>?): Int {
        if (node == null) {
            return 0
        }

        return height(node.left) - height(node.right)
    }

    private fun leftRotate(g: Node<T>): Node<T> {
        val rightChild = g.right
        val t3 = rightChild!!.left

        rightChild.left = g
        g.right = t3
        g.isRed = true
        rightChild.isRed = false
        return rightChild
    }

    private fun rightRotate(g: Node<T>): Node<T> {
        val leftChild = g.left
        val t3 = leftChild!!.right

        leftChild.right = g
        g.left = t3
        g.isRed = true
        leftChild.isRed = false
        return leftChild
    }

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: Node<T>?, value: T): Node<T> {
        if (node == null) {
            return Node(value, false)
        }

        //1 Standard insertion
        when {
            value < node.value -> node.left = insert(node.left, value)
            value > node.value -> node.right = insert(node.right, value)
            else -> //similar value not accept
                return node
        }

        //2 update height
        node.height = max(height(node.left), height(node.right)) + 1

        if (!isRed(node.left) && isRed(node.right)) {
            return leftRotate(node)
        } else if (isRed(node.left) && isRed(node.left?.left)) {
            return rightRotate(node)
        } else if (isRed(node.left) && isRed(node.right)) {
            flipColors(node)
        }
        return node
    }

    private fun flipColors(node: Node<T>) {
        node.isRed = !node.isRed
        node.left!!.isRed = !node.left!!.isRed
        node.right!!.isRed = !node.right!!.isRed
    }

    private fun isRed(node: Node<T>?): Boolean {
        if (node == null) {
            return false
        }
        return node.isRed
    }

    private fun preOrder(node: Node<T>?, sb: StringBuilder) {
        if (node != null) {
            sb.append(node.value).append(" ")
            preOrder(node.left, sb)
            preOrder(node.right, sb)
        }
    }

    fun preOrder(): String {
        val sb = StringBuilder()
        preOrder(root, sb)
        return sb.toString()
    }
}