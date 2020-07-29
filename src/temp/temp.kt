package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
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
            right = if(linkedList.isNotEmpty())
                Node(linkedList.remove()) else null
        }
        nodeList.apply {
            addLast(poppedNode.left)
            addLast(poppedNode.right)
        }
    }
    return head
}