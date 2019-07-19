package structures

import java.lang.StringBuilder

class BinaryTree<T : Comparable<T>> {

    private var root: Node<T>? = null

    private class Node<T>(val value: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null

        constructor(left: Node<T>?, right: Node<T>?, value: T) : this(value) {
            this.left = left
            this.right = right
        }
    }

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: Node<T>?, value: T): Node<T> {
        if (node == null) {
            return Node(value)
        }

        when {
            value < node.value -> {
                node.left = insert(node.left, value)
            }
            value > node.value -> {
                node.right = insert(node.right, value)
            }
            else -> {
                return node
            }
        }
        return node
    }

    fun delete(value: T) {
        root = deleteNode(root, value)
    }

    private fun deleteNode(root: Node<T>?, value: T): Node<T>? {
        if (root == null) return root

        when {
            value < root.value -> root.left = deleteNode(root.left, value)
            value > root.value -> root.right = deleteNode(root.right, value)
            else -> //node with no leaf nodes
                return if (root.left == null && root.right == null) {
                    null
                } else if (root.left == null) {
                    root.right
                } else if (root.right == null) {
                    root.left
                } else {
                    val minValue = minValue(root.right!!)
                    Node(root.left, deleteNode(root.right, minValue), minValue)
                }
        }
        return root
    }

    private fun minValue(root: Node<T>): T {
        val tmp = root.left
        if (tmp != null) {
            return minValue(tmp)
        }
        return root.value
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

    private fun inOrder(node: Node<T>?, sb: StringBuilder) {
        if (node != null) {
            inOrder(node.left, sb)
            sb.append(node.value).append(" ")
            inOrder(node.right, sb)
        }
    }

    fun inOrder(): String {
        val sb = StringBuilder()
        inOrder(root, sb)
        return sb.toString()
    }
}