package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

fun performConstruction(list: IntArray, start: Int, end: Int): Node? {
    if (start > end) return null
    val middle = (start + end) / 2
    val node = Node(value = list[middle])
    node.left = trees.performConstruction(list, start, middle - 1)
    node.right = trees.performConstruction(list, middle + 1, end)
    return node
}