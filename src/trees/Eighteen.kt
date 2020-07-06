package trees

import ds.preOrderTraversal
import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Remove all nodes whose length = k in a given BT
 */

fun main() {
    val head = constructBalancedTree()
    preOrderTraversal(removePaths(head, 1))
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun removePaths(head: Node?, k: Int): Node? {
    if (head == null || k == 0) return null
    head.left = removePaths(head.left, k - 1)
    head.right = removePaths(head.right, k - 1)
    return head
}