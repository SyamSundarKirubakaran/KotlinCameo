package trees

import ds.preOrderTraversal
import trees.util.Node
import trees.util.constructSumTreeInput

/**
 * @author SYAM K
 * @problem : BT into a BT that holds child sum property
 */

fun main() {
    val head = constructSumTreeInput()
    convertTree(head)
    preOrderTraversal(head)
}

/**
 *           55
 *       /        \
 *      10        25
 *    /   \     /    \
 *   9     4   3     11
 *  / \   / \ / \    / \
 *               4
 *              / \
 */

/**
 *            55
 *        /        \
 *      30          25
 *    /    \      /    \
 *   26     4    14     11
 *  / \    / \  /  \   /  \
 *                 14
 *                /  \
 */

fun convertTree(head: Node?) {
    var leftData = 0
    var rightData = 0
    val diff: Int
    if (head?.left != null || head?.right != null) {
        convertTree(head.left)
        convertTree(head.right)
        head.left?.let {
            leftData = it.value
        }
        head.right?.let {
            rightData = it.value
        }
        diff = leftData + rightData - head.value
        if(diff > 0){
            head.value += diff
        } else {
            increment(head, -diff)
        }
    }
}

fun increment(head: Node?, diff: Int) {
    if (head != null){
        if(head.left != null){
            head.left!!.value += diff
            increment(head.left, diff)
        } else if(head.right != null){
            head.right!!.value += diff
            increment(head.right, diff)
        }
    }
}
