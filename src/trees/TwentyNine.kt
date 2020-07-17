package trees

import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Diagonal Traversal of a BT
 */

private var map: HashMap<Int, MutableList<Node>> = HashMap<Int, MutableList<Node>>()

fun main() {
    val head = constructBalancedTree()
    performDiagonalTraversal(head, 0)
    println(map.map { it.value.map { it.value } })
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun performDiagonalTraversal(head: Node?, d: Int) {
    if (head == null) return
    val n = map[d]
    if (n == null) {
        val list = LinkedList<Node>()
        list.add(head)
        map[d] = list
    } else {
        n.add(head)
        map[d] = n
    }
    performDiagonalTraversal(head.left, d + 1)
    performDiagonalTraversal(head.right, d)
}