package trees

import trees.util.Node
import trees.util.constructDiffTree

/**
 * @author SYAM K
 * @problem : Max of all differences of a node and it's ancestors BT
 */

private var max: Int = Int.MIN_VALUE

fun main() {
    val head = constructDiffTree()
    findMaxDiff(head)
    println(max)
}

/**
 *           25
 *       /       \
 *      32       45
 *    /   \     /  \
 *   3     50  2   15
 *  / \   / \ / \  / \
 *       4      -5
 *
 * op: 50
 */

fun findMaxDiff(head: Node?): Int {
    if(head == null) return Int.MAX_VALUE
    if(head.left == null && head.right == null)
        return head.value
    val left = findMaxDiff(head.left)
    val right = findMaxDiff(head.right)
    val min = Math.min(left, right)
    max = Math.max(max, head.value - min)
    return Math.min(min, head.value)
}