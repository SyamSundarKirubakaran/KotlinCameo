package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */


fun findKDistanceFromLeaf(
    head: Node?,
    path: IntArray,
    visited: BooleanArray,
    pathLength: Int,
    k: Int
) {
    if (head == null) return
    path[pathLength] = head.value
    visited[pathLength] = false
    if (isLeafNode(head) && pathLength - k >= 0 && !visited[pathLength - k]) {
        println(path[pathLength - k])
        visited[pathLength - k] = true
    }
    findKDistanceFromLeaf(head.left, path, visited, pathLength + 1, k)
    findKDistanceFromLeaf(head.right, path, visited, pathLength + 1, k)
}

fun isLeafNode(node: Node): Boolean {
    return node.left == null && node.right == null
}