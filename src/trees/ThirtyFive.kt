package trees

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Complete BT from a LL
 */

val linkedList = LinkedList(listOf(1, 2, 3, 4, 5, 6, 7))

fun main() {
    val head = constructTree(linkedList)
    ds.preOrderTraversal(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun constructTree(linkedList: LinkedList<Int>): Node {
    val popped = linkedList.removeFirst()
    val head = Node(popped)
    val nodeList = LinkedList<Node>()
    nodeList.addLast(head)
    while (linkedList.isNotEmpty()){
        val poppedNode = nodeList.remove()
        poppedNode.apply {
            left = Node(linkedList.remove())
            right = if(linkedList.isNotEmpty()) Node(linkedList.remove()) else null
        }
        nodeList.apply {
            addLast(poppedNode.left)
            addLast(poppedNode.right)
        }
    }
    return head
}