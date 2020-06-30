package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Vertical Tree Order Traversal
 */

private var min = Int.MAX_VALUE
private var max = Int.MIN_VALUE

fun main() {
    val head = constructBalancedTree()
    printVertical(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun printVertical(head: Node) {
    findMinMax(head, 0)
    for (i in min..max) {
        performPrint(head, i, 0)
    }
}

fun performPrint(head: Node?, index: Int, localIndex: Int) {
    if (head == null) return
    if (index == localIndex) println(head.value)
    performPrint(head.left, index, localIndex - 1)
    performPrint(head.right, index, localIndex + 1)
}

fun findMinMax(head: Node?, index: Int) {
    if (head == null) return
    if (index < min) min = index
    if (index > max) max = index
    findMinMax(head.left, index - 1)
    findMinMax(head.right, index + 1)
}