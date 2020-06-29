package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Print Nodes at K distance from the root
 */

fun main() {
    val head = constructBalancedTree()
    findNodes(head, 0, 1)
}


/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findNodes(head: Node?, currentDistance: Int, k: Int) {
    head?.let {
        if (currentDistance == k) {
            print("${head.value} ")
            return
        }
        findNodes(head.left, currentDistance + 1, k)
        findNodes(head.right, currentDistance + 1, k)
    }
}
