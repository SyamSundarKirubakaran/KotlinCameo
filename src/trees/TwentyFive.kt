package trees

import ds.preOrderTraversal
import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : BT construction from a given PRE and IN Order
 */

var postOrderIndex: Int = 0
private val inOrder: MutableList<Int> = LinkedList()
private val postOrder: MutableList<Int> = LinkedList()

fun main() {
    val head = constructBalancedTree()
    findInOrder(head)
    println()
    findPostOrder(head)
    println()
    postOrderIndex = inOrder.size - 1
    val resultHead = construct(0, inOrder.size - 1)
    preOrderTraversal(resultHead)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun construct(
    start: Int,
    end: Int
): Node? {
    if (start > end) return null
    val head = Node(value = postOrder[postOrderIndex])
    postOrderIndex -= 1
    if (start == end) return head
    val index = searchInInOrder(inOrder, start, end, head.value)
    head.right = construct(index + 1, end)
    head.left = construct(start, index - 1)
    return head
}

fun searchInInOrder(inOrder: List<Int>, inStart: Int, inEnd: Int, value: Int): Int {
    for (i in inStart..inEnd) {
        if (inOrder[i] == value) return i
    }
    return -1
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findPostOrder(head: Node?) {
    if (head != null) {
        findPostOrder(head.left)
        findPostOrder(head.right)
        postOrder.add(head.value)
        print("${head.value} ")
    }
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findInOrder(head: Node?) {
    if (head != null) {
        findInOrder(head.left)
        inOrder.add(head.value)
        print("${head.value} ")
        findInOrder(head.right)
    }
}