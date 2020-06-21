package trees

import ds.preOrderTraversal
import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Mirror Tree
 */

fun main() {
    val head = constructBalancedTree()
    preOrderTraversal(head)
    mirrorTree(head)
    println()
    preOrderTraversal(head)
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
 *           1
 *       /       \
 *      3         2
 *    /   \     /  \
 *   7     6   5    4
 *  / \   / \ / \  / \
 */


fun mirrorTree(head: Node?) {
    head?.let {
        mirrorTree(head.left)
        mirrorTree(head.right)
        val temp = head.left
        head.left = head.right
        head.right = temp
    }
}
