package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : All nodes at K distance from leaf
 */

fun main() {
    val head = constructBalancedTree()
    val path = IntArray(1000)
    val visited = BooleanArray(1000)
    findKDistanceFromLeaf(head, path, visited, 0, 1)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
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
    val chosenPos = pathLength - k
    if (isLeafNode(head) && chosenPos >= 0 && !visited[chosenPos]) {
        println(path[chosenPos])
        visited[chosenPos] = true
    }
    findKDistanceFromLeaf(head.left, path, visited, pathLength + 1, k)
    findKDistanceFromLeaf(head.right, path, visited, pathLength + 1, k)
}

fun isLeafNode(node: Node): Boolean {
    return node.left == null && node.right == null
}