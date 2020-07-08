package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

fun cousin(node: Node, one: Node, two: Node): Boolean {
    return level(node, one, 1) == level(node, two, 1) && !sibling(node, one, two)
}

fun sibling(node: Node, one: Node, two: Node): Boolean {
    return if (node.left == null || node.right == null) false
    else node.left!!.value == one.value && node.right!!.value == two.value ||
            node.right!!.value == one.value && node.left!!.value == two.value ||
            sibling(node.left!!, one, two) ||
            sibling(node.right!!, one, two)
}

fun level(node: Node?, searchNode: Node, level: Int): Int {
    if (node == null) return 0
    if (node.value == searchNode.value) return level
    val left = level(node.left, searchNode, level + 1)
    return if (left != 0) left else level(node.right, searchNode, level + 1)
}