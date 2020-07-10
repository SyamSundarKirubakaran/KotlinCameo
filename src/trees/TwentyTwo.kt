package trees

import ds.preOrderTraversal
import trees.util.Node
import trees.util.skewedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : BST to Balanced BST
 */

private val list: MutableList<Int> = LinkedList()

fun main() {
    val head = skewedTree()
    performInOrderInflate(head)
    preOrderTraversal(constructBalancedBST(list, 0, list.size - 1))
}

/**
 *           2
 *       /      \
 *      1        4
 *    /   \    /   \
 */

fun constructBalancedBST(list: List<Int>, start: Int, end: Int): Node? {
    if (start > end) return null
    val middle = (start + end) / 2
    val head = Node(value = list[middle])
    head.left = constructBalancedBST(list, start, middle - 1)
    head.right = constructBalancedBST(list, middle + 1, end)
    return head
}

/**
 *    1
 *   / \
 *      2
 *     / \
 *        4
 *       / \
 */

fun performInOrderInflate(head: Node?) {
    if (head != null) {
        performInOrderInflate(head.left)
        list.add(head.value)
        performInOrderInflate(head.right)
    }
}