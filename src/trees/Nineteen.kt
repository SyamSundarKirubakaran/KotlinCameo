package trees

import trees.util.Node
import trees.util.constructBalancedTree
import trees.util.constructSubTree

/**
 * @author SYAM K
 * @problem : One BT is a subtree of another BT or not
 */

fun main() {
    val head = constructBalancedTree()
    val subHead = constructSubTree()
    print(subTree(head, subHead))
}


/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

/**
 *      2
 *    /   \
 *   4     5
 *  / \   / \
 */

fun subTree(head: Node?, smallerHead: Node?): Boolean {
    if(smallerHead == null) return true
    if(head == null) return false
    return if(identical(head, smallerHead)) true
    else subTree(head.left, smallerHead) || subTree(head.right, smallerHead)
}

fun identical(head: Node?, smallerHead: Node?): Boolean {
    if(head == null && smallerHead == null) return true
    return if(head == null || smallerHead == null) false
    else head.value == smallerHead.value &&
            identical(head.left, smallerHead.left) &&
            identical(head.right, smallerHead.right)
}