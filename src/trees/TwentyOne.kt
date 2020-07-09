package trees

import ds.preOrderTraversal
import trees.util.Node

/**
 * @author SYAM K
 * @problem : Balanced BST construction from a sorted list
 */

private var sortedList = intArrayOf(5, 10, 20, 30, 40, 50, 60)

fun main() {
    preOrderTraversal(performConstruction(sortedList, 0, sortedList.size - 1))
}

/**
 *           30
 *       /       \
 *      10       50
 *    /   \     /  \
 *   5    20  40   60
 *  / \   / \ / \  / \
 */

fun performConstruction(sortedList: IntArray, start: Int, end: Int): Node? {
    if (start > end) return null
    val middle = (start + end) / 2
    val head = Node(value = sortedList[middle])
    head.left = performConstruction(sortedList, start, middle - 1)
    head.right = performConstruction(sortedList, middle + 1, end)
    return head
}