package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Lowest Common Ancestor in a BT
 */

fun main() {
    val head = constructBalancedTree()
    println(lcaBT(head, 4, 7)?.value)
}


/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun lcaBT(head: Node?, p: Int, q: Int): Node? {
    head?.let {
        if (p == head.value || q == head.value)
            return head
        val left = lcaBT(head.left, p, q)
        val right = lcaBT(head.right, p, q)
        if (left != null && right != null) {
            return head
        }
        return left ?: right
    }
    return head
}