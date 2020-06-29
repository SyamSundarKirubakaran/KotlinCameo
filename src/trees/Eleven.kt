package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Nodes at k-distance from any node in a BT
 */

fun main() {
    val head = constructBalancedTree()
    printFromAnyNode(head, Node(value = 2), 2)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

// Similar to all nodes at a distance K from the root
fun printKDistanceDown(head: Node?, k: Int) {
    if (head == null || k < 0) {
        return
    }
    if (k == 0) {
        println(head.value)
        return
    }
    printKDistanceDown(head.left, k - 1)
    printKDistanceDown(head.right, k - 1)
}

fun printFromAnyNode(head: Node?, target: Node, k: Int): Int {
    if (head == null) return -1
    if (head.value == target.value) {
        printKDistanceDown(head, k)
        return 0
    }
    val dl = printFromAnyNode(head.left, target, k)
    if (dl != -1) {
        if (dl + 1 == k) println(head.value) else printKDistanceDown(head.right, k - dl - 2)
        return dl + 1
    }
    val dr = printFromAnyNode(head.right, target, k)
    if (dr != -1) {
        if (dr + 1 == k) println(head.value) else printKDistanceDown(head.left, k - dr - 2)
        return dr + 1
    }
    return -1
}