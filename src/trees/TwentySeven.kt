package trees

import trees.util.SNode
import trees.util.constructExpressionTree

/**
 * @author SYAM K
 * @problem : BT Expression Evaluation
 */

fun main() {
    val head = constructExpressionTree()
    println(evaluateExpression(head))
}

/**
 *           +
 *       /       \
 *      *         *
 *    /   \     /  \
 *   1     2   3    4
 *  / \   / \ / \  / \
 */

fun evaluateExpression(head: SNode?): String? {
    if(head == null) return "!"
    if(isLeaf(head)) return head.value
    val left = evaluateExpression(head.left)
    val right = evaluateExpression(head.right)
    head.value = when(head.value){
        "+" -> "${left!!.toInt() + right!!.toInt()}"
        "*" -> "${left!!.toInt() * right!!.toInt()}"
        else -> head.value
    }
    return head.value
}

fun isLeaf(head: SNode) = head.left == null && head.right == null

// "${left!!.toInt() + right!!.toInt()}"