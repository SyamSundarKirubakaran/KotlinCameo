package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

fun removePaths(node: Node?, k: Int): Node? {
    if (node == null || k == 0) return null
    node.left = trees.removePaths(node.left, k - 1)
    node.right = trees.removePaths(node.right, k - 1)
    return node
}