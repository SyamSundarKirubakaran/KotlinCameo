package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Left View of a Binary Tree
 */

private var max: Int = Int.MIN_VALUE

fun main() {
    val head = constructBalancedTree()
    leftView(head, 1)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun leftView(head: Node?, level: Int) {
    if (head == null) return
    if (level > max) { // MAX: -INF 1 2 3
        println(head.value)
        max = level
    }
    leftView(head.left, level + 1)
    leftView(head.right, level + 1)
}