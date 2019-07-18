package structures

internal class Node {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
    var isRed: Boolean = false
    var value: Int = 0

    constructor(value: Int) {
        this.value = value
    }

    constructor(value: Int, isRed: Boolean) {
        this.value = value
        this.isRed = isRed
    }
}

class RedBlackTree {
    private var root: Node? = null
    private var blackHeight = 0
    private var whiteHeight = 0

    private fun binaryInsert(value: Int): Node? {
        var tmp = root
        while (tmp != null) {
            if (value < tmp.value) {
                if (tmp.left == null) {//it's leaf
                    tmp.left = Node(value, true)
                    tmp.left!!.parent = tmp
                    return tmp.left
                } else {
                    tmp = tmp.left
                }
            } else {
                if (tmp.right == null) {
                    tmp.right = Node(value, true)
                    tmp.right!!.parent = tmp
                    return tmp.right
                } else {
                    tmp = tmp.right
                }
            }
        }
        return null
    }



    fun insert(value: Int) {
        if (root == null) {
            root = Node(value, false) //root only can be black
            blackHeight++
            return
        }
        val tmp = binaryInsert(value)
        if (tmp!=null && !tmp.parent!!.isRed && tmp != root) {
            if (tmp.parent!!.parent!=null && tmp.parent!!.parent!!.right!!.isRed) { //TODO is uncle always right? case a
                tmp.parent!!.isRed = false //Change color of parent to black
                tmp.parent!!.parent!!.right!!.isRed = false // Change color of uncle to black
                var x = tmp.parent!!.parent
                while (x != null) {
                    x.isRed = true
                    x = x.parent
                }
            } else if (tmp.parent!!.parent!=null && !tmp.parent!!.parent!!.right!!.isRed) { //Uncle is black
                //next four cases
                val grand = tmp.parent!!.parent
                val parent = tmp.parent
                if (grand?.left != null && grand.left == parent) { //LEFT
                    if (parent?.left != null && parent.left == tmp) { //LEFT LEFT CASE
                        val grandGrand = grand.parent
                        grand.parent = parent //Right rotation of grand
                        grand.left = parent.right
                        parent.right = grand
                        parent.parent = grandGrand

                        parent.isRed = false
                        grand.isRed = true //Colors
                    } else { //LEFT RIGHT CASE
                        //left rotate
                        val leftChild = tmp.left
                        tmp.parent = grand
                        grand.left = tmp
                        tmp.left = parent
                        parent!!.parent = tmp
                        parent.right = leftChild

                        //Left left case apply
                        val rightChild = tmp.right
                        grand.parent = tmp
                        grand.left = rightChild
                        tmp.right = grand
                    }
                } else { //RIGHT
                    if (parent?.right != null && parent.right == tmp) { // RIGHT RIGHT
                        //left rotate
                        val leftChild = parent.left
                        val grandgrand = grand?.parent
                        grand?.parent = parent
                        parent.left = grand
                        grand?.right = leftChild
                        parent.parent = grandgrand

                    } else { //RIGHT LEFT
                        //right rotate p
                        val rightChild = tmp.right
                        tmp.parent = grand
                        tmp.right = parent
                        parent?.parent = tmp
                        parent?.left = rightChild

                        //Apply right right case
                        val grandGrand = grand?.parent
                        tmp.parent = grandGrand
                        grand?.parent = tmp
                        val leftChild = tmp.left
                        grand?.right = leftChild
                        tmp.left = grand
                    }
                }
            }
        }
    }
}