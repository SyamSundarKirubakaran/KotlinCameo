package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private var min = Int.MAX_VALUE
private var max = Int.MIN_VALUE

fun printVertical(node: Node) {
    findMinMax(node, 0)
    for (i in min..max) {
        performPrint(node, i, 0)
    }
}

fun performPrint(node: Node?, index: Int, hd: Int) {
    if (node == null) return
    if (index == hd) println(node.value)
    performPrint(node.left, index, hd - 1)
    performPrint(node.right, index, hd + 1)
}

fun findMinMax(node: Node?, index: Int) {
    if (node == null) return
    if (index < min) min = index
    if (index > max) max = index
    findMinMax(node.left, index - 1)
    findMinMax(node.right, index + 1)
}