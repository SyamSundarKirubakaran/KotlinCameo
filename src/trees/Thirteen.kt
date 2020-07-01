package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Vertical Sum of a Binary Tree
 */

private var min = Int.MAX_VALUE
private var max = Int.MIN_VALUE

fun main() {
    val head = constructBalancedTree()
    performVerticalSum(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun performVerticalSum(head: Node) {
    finMinMax(head, 0)
    for (i in min..max) {
        println(computeSum(head, i, 0))
    }
}

fun computeSum(head: Node?, lineNo: Int, hd: Int): Int {
    if (head == null) return 0
    return if (lineNo == hd)
        head.value + computeSum(head.left, lineNo, hd - 1) + computeSum(head.right, lineNo, hd + 1)
    else computeSum(head.left, lineNo, hd - 1) + computeSum(head.right, lineNo, hd + 1)
}

fun finMinMax(head: Node?, index: Int) {
    if (head == null) return
    if (index < min) min = index
    if (index > max) max = index
    finMinMax(head.left, index - 1)
    finMinMax(head.right, index + 1)
}