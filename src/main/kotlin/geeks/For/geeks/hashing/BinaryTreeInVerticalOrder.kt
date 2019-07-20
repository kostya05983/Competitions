package geeks.For.geeks.hashing

import kotlin.math.max


class BinaryTreeInVerticalOrder<T : Comparable<T>> {
    private var root: Node<T>? = null

    private class Node<T> {
        var left: Node<T>? = null
        var right: Node<T>? = null
        var height = 1
        val value: T

        constructor(value: T) {
            this.value = value
            height = 1
        }

        constructor(leftNode: Node<T>?, rightNode: Node<T>?, value: T, height: Int) {
            this.left = leftNode
            this.right = rightNode
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

    fun insert(value: T) {
        root = insert(root, value)
    }

    /**
     * Get balance of tree to understand next step of balance
     */
    private fun getBalance(node: Node<T>?): Int {
        if (node == null) {
            return 0
        }
        return height(node.left) - height(node.right)
    }

    private fun rightRotate(z: Node<T>): Node<T> {
        val y = z.left
        val t2 = y?.right

        y!!.right = z
        z.left = t2

        z.height = maxOf(height(z.left), height(z.right)) + 1
        y.height = maxOf(height(y.left), height(y.right)) + 1

        return y
    }

    private fun leftRotate(z: Node<T>): Node<T> {
        val y = z.right
        val t2 = y?.left

        y!!.left = z
        z.right = t2

        z.height = maxOf(height(z.left), height(z.right)) + 1
        y.height = maxOf(height(y.left), height(y.right)) + 1
        return y
    }

    private fun insert(node: Node<T>?, value: T): Node<T> {
        if (node == null) {
            return Node(value)
        }

        when {
            value < node.value -> node.left = insert(node.left, value)
            value > node.value -> node.right = insert(node.right, value)
            else -> return node
        }

        //2. after standard insert, update  height
        node.height = 1 + max(height(node.left), height(node.right))

        val balanced = getBalance(node)

        //left left case
        if (balanced > 1 && node.left != null && value < node.left!!.value) {
            return rightRotate(node)
        }
        // right right case
        if (balanced < -1 && node.right != null && value > node.right!!.value) {
            return leftRotate(node)
        }
        // left right case
        if (balanced > 1 && node.left != null && value > node.left!!.value) {
            node.left = leftRotate(node.left!!)
            return rightRotate(node)
        }
        // right left case
        if (balanced < -1 && node.right != null && value < node.right!!.value) {
            node.right = rightRotate(node.right!!)
            return leftRotate(node)
        }


        return node
    }

    fun printVertical(): String {
        val sb = StringBuilder()
        val map = hashMapOf<Int, ArrayList<T>>()
        printVertical(root, 0, map)
        for ((key, value) in map) {
            sb.append(key).append("-")
            for (node in value) {
                sb.append(node)
            }
            sb.appendln()
        }
        return sb.toString()
    }

    private fun printVertical(node: Node<T>?, pos: Int, hashMap: HashMap<Int, ArrayList<T>>) {
        if (node != null) {
            if (hashMap[pos] == null) {
                hashMap[pos] = ArrayList()
                hashMap[pos]?.add(node.value)
            } else {
                hashMap[pos]?.add(node.value)
            }

            printVertical(node.left, pos - 1, hashMap)
            printVertical(node.right, pos + 1, hashMap)
        }
    }
}