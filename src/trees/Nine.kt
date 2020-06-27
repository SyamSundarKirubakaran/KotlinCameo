package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Find the level of a given node in a binary tree
 */


fun main() {
    val head = constructBalancedTree()
    print(findLevel(head, 1, 4))
}


/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findLevel(head: Node?, level: Int, key: Int): Int {
    if (head == null) return -1
    if (head.value == key) return level
    val leftSearch = findLevel(head.left, level + 1, key)
    return if (leftSearch != -1) leftSearch else findLevel(head.right, level + 1, key)
}