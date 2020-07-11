package trees

import trees.util.Node
import trees.util.constructSumTree

/**
 * @author SYAM K
 * @problem : Sum Tree or not
 */

fun main() {
    val head = constructSumTree()
    print(checkSumTree(head))
}

/**
 *           50
 *       /       \
 *      15       10
 *    /   \     /  \
 *   10    5   7    3
 *  / \   / \ / \  / \
 */

fun checkSumTree(head: Node?): Boolean {
//    if(head == null || isLeaf(head)) return true
//    if(checkSumTree(head.left) && checkSumTree(head.right)){
//        val leftSum = when {
//            head.left == null -> 0
//            isLeaf(head.left) -> head.left!!.value
//            else -> 2 * head.left!!.value
//        }
//        val rightSum = when {
//            head.right == null -> 0
//            isLeaf(head.right) -> head.right!!.value
//            else -> 2 * head.right!!.value
//        }
//        return head.value == leftSum + rightSum
//    }
    return false
}

fun isLeaf(head: Node?): Boolean {
    return if(head == null) false
    else head.left == null && head.right == null
}