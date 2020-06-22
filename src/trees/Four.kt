package trees

import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Level Order Traversal
 */

fun main() {
    val head = constructBalancedTree()
    performLevelOrderTraversal(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun performLevelOrderTraversal(head: Node?) {
    val queue: Queue<Node> = LinkedList()
    head?.let {
        queue.add(head)
        while (queue.isNotEmpty()){
            val removed = queue.remove()
            print("${removed.value} ")
            removed.left?.let {
                queue.add(it)
            }
            removed.right?.let {
                queue.add(it)
            }
        }
    }
}