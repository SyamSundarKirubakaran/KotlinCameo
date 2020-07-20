package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private var max: Int = Int.MIN_VALUE

fun findMaxDiff(node: Node?): Int {
    if (node == null) return Int.MAX_VALUE
    if (node.left == null && node.right == null) return node.value
    val left: Int = trees.findMaxDiff(node.left)
    val right: Int = trees.findMaxDiff(node.right)
    val min = Math.min(left, right)
    max = Math.max(max, node.value - min)
    return Math.min(min, node.value)
}
