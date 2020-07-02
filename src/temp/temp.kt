package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

fun checkSumTree(head: Node?): Boolean {
    if (head == null || isLeaf(head)) return true
    if (trees.checkSumTree(head.left) && trees.checkSumTree(head.right)) {
        val leftSum = when {
            head.left == null -> 0
            isLeaf(head.left) -> head.left!!.value
            else -> 2 * head.left!!.value
        }
        val rightSum = when {
            head.right == null -> 0
            isLeaf(head.right) -> head.right!!.value
            else -> 2 * head.right!!.value
        }
        return head.value == leftSum + rightSum
    }
    return false
}

fun isLeaf(head: Node?): Boolean {
    return if (head == null) false
    else head.left == null && head.right == null
}